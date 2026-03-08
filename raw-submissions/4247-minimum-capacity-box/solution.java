class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int min = Integer.MAX_VALUE, idx = -1;
        for(int i = 0; i < capacity.length; i++){
            if(capacity[i] >= itemSize){
                int diff = capacity[i] - itemSize;
                if(diff < min){
                    min = diff;
                    idx = i;
                }
            }
        }
        return idx;
    }
}
