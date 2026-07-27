class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        if(res >= 0) return res;
        else return -(res + 1);
    }
}
