class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int var = 0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int num : nums2){
            if(map.containsKey(num)){
               return num;
            }
        }
        return -1;
    }
}
