class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cumSum = 0 , validLeftPoint = 0;
        long res = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                validLeftPoint += map.getOrDefault(cumSum, 0);
                cumSum += 1;
            }
            else{
                cumSum--;
                validLeftPoint -= map.getOrDefault(cumSum, 0);
            }
            map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
            res += validLeftPoint;
        }
        return res;
    }
}
