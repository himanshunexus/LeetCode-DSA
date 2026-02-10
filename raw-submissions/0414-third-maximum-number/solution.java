class Solution {
    public int thirdMax(int[] nums) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       HashSet<Integer> vis = new HashSet<>();

        for(int i : nums){
            if(vis.add(i)){
                pq.add(i);
            }
            if(pq.size() > 3){
                pq.remove();
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
