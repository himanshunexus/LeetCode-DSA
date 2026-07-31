class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        int ans = 0;
        int count = 0; 

        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            count++;
            if (count <= 8) {
                ans += 1 * map.get(c);
            } else if (count <= 16) {
                ans += 2 * map.get(c);
            } else if (count <= 24) {
                ans += 3 * map.get(c);
            } else {
                ans += 4 * map.get(c);
            }
        }
        return ans;
    }
}
