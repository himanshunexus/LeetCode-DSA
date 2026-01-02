class Solution {
    public int repeatedNTimes(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int var : nums){
        map.put(var,map.getOrDefault(var,0)+1);
       } 
       for(int key : map.keySet()){
         if (map.get(key) > 1) {
            return key;
        }
    }
       return -1;
    }
}
