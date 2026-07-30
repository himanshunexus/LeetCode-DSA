class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int n = word.length();

        if(n <= 8) return n;

        else if(n > 8 && n <= 16){
            int curr = n - 8;
            ans = 8 + curr * 2;
        }

        else if(n > 16 && n <= 24){
            int curr = n - 16;
            ans = 24 + curr * 3;
        }

        else if(n > 24){
            int curr = n - 24;
            ans = 48 + curr * 4;
        }
        return ans;
    }
}
