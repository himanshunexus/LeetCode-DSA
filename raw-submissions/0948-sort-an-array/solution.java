class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for(int ele : nums ){
            pq.add(ele);
        }
        while(pq.size()>0) nums[idx++] = pq.remove();
        return nums;
    }
}
