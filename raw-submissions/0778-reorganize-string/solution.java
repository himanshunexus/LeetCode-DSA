class Solution {
    public String reorganizeString(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) freq[c - 'a']++;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (int i = 0; i < 26; i++)
        if (freq[i] > 0) pq.offer(new int[]{i, freq[i]});

    if (pq.peek()[1] > (s.length() + 1) / 2) return "";

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
        int[] top = pq.poll();
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char)(top[0] + 'a')) {
            sb.append((char)(top[0] + 'a'));
            if (--top[1] > 0) pq.offer(top);
        } else {
            if (pq.isEmpty()) return "";  
            int[] second = pq.poll();
            sb.append((char)(second[0] + 'a'));
            if (--second[1] > 0) pq.offer(second);
            pq.offer(top); 
        }
    }
    return sb.toString();
    }
}
