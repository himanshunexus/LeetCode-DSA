class Solution {
    public boolean uniformArray(int[] nums1) {
        int evenCount = 0 , oddCount = 0;
        int n = nums1.length;
        for(int x : nums1){
            if(x % 2 == 0)
                evenCount++;
            oddCount++;
        }
        if(evenCount == n || oddCount == n)
            return true;
        if(evenCount > 0 && oddCount > 0)
            return true;
        return false;
    }
}
