import json
import os
import shutil

import requests

GITHUB_WORKSPACE = os.getenv("GITHUB_WORKSPACE", ".")
TOPICS_FOLDER = os.path.join(GITHUB_WORKSPACE, "topics")
RAW_FOLDER = os.path.join(TOPICS_FOLDER, "raw-submissions")
SOLVED_INDEX_FILE = os.path.join(TOPICS_FOLDER, "solved-problems.json")

LEETCODE_GRAPHQL_URL = "https://leetcode.com/graphql"
QUESTION_DETAILS_QUERY = """
query singleQuestionDetails($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    questionFrontendId
    title
    titleSlug
    difficulty
    acRate
    topicTags {
      name
    }
  }
}
"""


def get_problem_details(title_slug):
    try:
        response = requests.post(
            LEETCODE_GRAPHQL_URL,
            json={"query": QUESTION_DETAILS_QUERY, "variables": {"titleSlug": title_slug}},
            headers={"Content-Type": "application/json"},
            timeout=15,
        )
        response.raise_for_status()
        data = response.json()
        return data.get("data", {}).get("question")
    except Exception as e:
        print(f"Error fetching details for {title_slug}: {e}")
    return None


def get_title_slug_from_folder(folder_name):
    slug_parts = folder_name.split("-", 1)
    return slug_parts[1] if len(slug_parts) > 1 else folder_name


def normalize_topic(topic_name):
    return topic_name.replace(" ", "-") if topic_name else "Uncategorized"


def organize():
    if not os.path.exists(RAW_FOLDER):
        print("No raw-submissions folder found.")
        return

    solved_index = {}
    os.makedirs(TOPICS_FOLDER, exist_ok=True)

    for root, _, files in os.walk(RAW_FOLDER):
        if not files:
            continue

        folder_name = os.path.basename(root)
        if folder_name == os.path.basename(RAW_FOLDER):
            continue

        title_slug = get_title_slug_from_folder(folder_name)
        question_details = get_problem_details(title_slug) or {}
        tags = question_details.get("topicTags", [])
        primary_topic = normalize_topic(tags[0]["name"]) if tags else "Uncategorized"

        target_dir = os.path.join(TOPICS_FOLDER, primary_topic, folder_name)
        os.makedirs(target_dir, exist_ok=True)

        for file in files:
            src_file = os.path.join(root, file)
            dest_file = os.path.join(target_dir, file)
            shutil.move(src_file, dest_file)
            print(f"Moved {file} -> topics/{primary_topic}/{folder_name}/")

        solved_index[title_slug] = {
            "questionFrontendId": question_details.get("questionFrontendId"),
            "title": question_details.get("title", title_slug.replace("-", " ").title()),
            "titleSlug": title_slug,
            "difficulty": question_details.get("difficulty"),
            "acceptanceRate": question_details.get("acRate"),
            "topics": [tag.get("name") for tag in tags if tag.get("name")],
            "solutionPath": f"topics/{primary_topic}/{folder_name}",
        }

    with open(SOLVED_INDEX_FILE, "w", encoding="utf-8") as solved_file:
        json.dump(
            sorted(solved_index.values(), key=lambda item: item["titleSlug"]),
            solved_file,
            indent=2,
            ensure_ascii=False,
        )
    print(f"Generated solved problems index: topics/solved-problems.json")

    shutil.rmtree(RAW_FOLDER, ignore_errors=True)


if __name__ == "__main__":
    organize()
