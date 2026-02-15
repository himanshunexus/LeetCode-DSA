class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int k : map.values()){
            freq.put(k,freq.getOrDefault(k,0)+1);
        }
        for(int x : nums){
            int freqCount = map.get(x);
            if(freq.getOrDefault(freqCount , 0) == 1){
                return x;
                }
            }
        return -1;
    }
}
