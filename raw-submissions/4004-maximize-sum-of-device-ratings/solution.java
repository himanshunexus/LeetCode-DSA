class Solution {
    public long maxRatings(int[][] units) {
        long sumSecond = 0;
        int smallestFirst = Integer.MAX_VALUE;
        int smallestSecond = Integer.MAX_VALUE;

        for(int[] row : units){
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for(int x : row){
                if(x <= first){
                    second = first;
                    first = x;
                }
                else if(x < second){
                    second = x;
                }
            }
            if(second == Integer.MAX_VALUE){
                second = first;
            }
            sumSecond += second;
            smallestFirst = Math.min(smallestFirst , first);
            smallestSecond = Math.min(smallestSecond , second);
        }
        return sumSecond - smallestSecond + smallestFirst;
    }
}
