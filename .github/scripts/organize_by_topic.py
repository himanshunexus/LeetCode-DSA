import os
import shutil
import requests

GITHUB_WORKSPACE = os.getenv("GITHUB_WORKSPACE", ".")
RAW_FOLDER = os.path.join(GITHUB_WORKSPACE, "raw-submissions")
TOPICS_FOLDER = os.path.join(GITHUB_WORKSPACE, "Topics")

LEETCODE_GRAPHQL_URL = "https://leetcode.com/graphql"

def get_problem_topic(title_slug):
    query = """
    query singleQuestionTopicTags($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        topicTags {
          name
        }
      }
    }
    """
    try:
        response = requests.post(
            LEETCODE_GRAPHQL_URL,
            json={"query": query, "variables": {"titleSlug": title_slug}},
            headers={"Content-Type": "application/json"}
        )
        data = response.json()
        tags = data.get("data", {}).get("question", {}).get("topicTags", [])
        if tags:
            return tags[0]["name"].replace(" ", "-") # Uses the primary topic
    except Exception as e:
        print(f"Error fetching topic for {title_slug}: {e}")
    return "Uncategorized"

def organize():
    if not os.path.exists(RAW_FOLDER):
        print("No raw-submissions folder found.")
        return

    for root, dirs, files in os.walk(RAW_FOLDER):
        for file in files:
            # Get title_slug from directory name or filename
            parts = root.split(os.sep)
            if len(parts) > 1:
                folder_name = parts[-1]
                # Leetcode-sync formats folders like "0001-two-sum"
                slug_parts = folder_name.split("-", 1)
                title_slug = slug_parts[1] if len(slug_parts) > 1 else folder_name

                topic = get_problem_topic(title_slug)
                target_dir = os.path.join(TOPICS_FOLDER, topic, folder_name)
                os.makedirs(target_dir, exist_ok=True)

                src_file = os.path.join(root, file)
                dest_file = os.path.join(target_dir, file)
                shutil.move(src_file, dest_file)
                print(f"Moved {file} -> Topics/{topic}/{folder_name}/")

    # Clean up empty raw folder
    shutil.rmtree(RAW_FOLDER, ignore_errors=True)

if __name__ == "__main__":
    organize()
