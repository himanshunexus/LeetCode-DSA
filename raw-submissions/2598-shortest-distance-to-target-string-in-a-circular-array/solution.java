class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(words[i].equals(target)){
                int dist = Math.abs(i - startIndex);
                int actualDist = Math.min(dist, n - dist);
                min = Math.min(min, actualDist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
