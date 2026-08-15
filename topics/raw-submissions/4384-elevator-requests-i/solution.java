class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int total = 0 , curr = 0;
        for(int i : requests){
            total += Math.abs(i - curr);
            curr = i;
        }
        return total;
    }
}
