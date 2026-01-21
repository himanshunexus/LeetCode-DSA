class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int diffA = Math.abs(a - x);
                int diffB = Math.abs(b - x);
                if (diffA != diffB) {
                    return diffB - diffA;
                }
                return b - a;
            }
        );
        for(int ele : arr){
            pq.add(ele);
            if(pq.size()>k) 
                pq.remove();
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove());
        }
        Collections.sort(result);
        return result;
    }
}
