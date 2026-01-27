class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int jump2 = 1, jump1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = jump1 + jump2;
            jump2 = jump1;
            jump1 = curr;
        }
        return jump1;
    }
}
