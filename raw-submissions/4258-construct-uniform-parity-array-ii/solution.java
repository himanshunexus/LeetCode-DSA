class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int min = nums1[0];
        boolean hasEven = false , hasOdd = false;
        for(int x : nums1){
            if(x % 2 == 0)
                hasEven = true;
            else
                hasOdd = true;
        }
        if(min % 2 == 0){
            return !hasOdd;
        }else{
            return true;
        }
    }
}
