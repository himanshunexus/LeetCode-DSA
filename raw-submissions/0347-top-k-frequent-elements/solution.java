class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int ele : nums ){
        map.put(ele,map.getOrDefault(ele,0)+1);
       } 
       PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) {
            pq.add(key);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove();
        }

        return ans;
    }
}
