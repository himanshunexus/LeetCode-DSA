class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();
        if(n <= 1) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int sIdx = 0;
        for(int i = 0; i < n; i++){
            while(sIdx < m && station.charAt(sIdx) != skill.charAt(i)){
                sIdx++;
            }
            left[i] = sIdx;
            sIdx++;
        }
        sIdx = m - 1;
        for(int i = n - 1; i >= 0; i--){
            while(sIdx >= 0 && station.charAt(sIdx) != skill.charAt(i)){
                sIdx--;
            }
            right[i] = sIdx;
            sIdx--;
        }
        int max = 0;
        for(int i = 1; i < n; i++){
            max = Math.max(max , right[i] - left[i - 1]);
        }
        return max;
    }
}
