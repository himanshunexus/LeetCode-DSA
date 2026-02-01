class Solution {
    public int minimumCost(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        
        return nums[0] + pq.poll() + pq.poll();
    }
}
