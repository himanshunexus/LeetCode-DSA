class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diff = new int[n];

        for(int i = 0; i < n; i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        
        for(int k = 0; k < n && additionalRocks >= diff[k]; k++){
            additionalRocks -= diff[k];
            diff[k] = 0;
        }

        int count = 0;

        for(int z = 0; z < n; z++){
            if(diff[z] == 0) count++;
        }

        return count;
    }
}
