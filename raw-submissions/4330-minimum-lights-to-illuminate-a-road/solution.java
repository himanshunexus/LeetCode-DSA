class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[] diff = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(lights[i] > 0){
                int l = Math.max(0 , i - lights[i]);
                int r = Math.min(n - 1, i + lights[i]);
                diff[l]++;
                diff[r + 1]--;
            }
        }
        boolean[] vis = new boolean[n];
        int cover = 0;
        for(int i = 0; i < n; i++){
            cover += diff[i];
            vis[i] = cover > 0;
        }
        int ans = 0;
        int i = 0;
        while(i < n){
            if(vis[i]){
                i++;
                continue;
            }
            int len = 0;
            while(i < n && !vis[i]){
                len++;
                i++;
            }
            ans += (len + 2) / 3;
        }
        return ans;
    }
}
