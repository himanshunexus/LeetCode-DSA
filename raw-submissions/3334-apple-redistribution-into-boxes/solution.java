class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int appleSum = 0;
        for(int i=0;i<apple.length;i++){
            appleSum+=apple[i];
        }
        int capacitySum = 0;
        int count=0;
        for(int i = capacity.length - 1; i >= 0; i--){
            capacitySum+=capacity[i];
            count++;
            if(capacitySum >= appleSum){
                break;
            }
        }
       return count;
    }
}
