class Solution {
    public int absDifference(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            maxHeap.add(i);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int x : nums){
            minHeap.add(x);
            if(minHeap.size()> k){
                minHeap.remove();
            }
        }
        int maxSum = 0;
        int minSum = 0;
        while (!maxHeap.isEmpty()) {
            minSum += maxHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            maxSum += minHeap.poll();
        }
        return (int)Math.abs(maxSum - minSum);
    }
}
