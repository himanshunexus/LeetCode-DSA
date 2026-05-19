class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0, right = 0;
        int[] res = new int[n + m];
        int i = 0; 

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                res[i] = nums1[left]; 
                left++;
            } else {
                res[i] = nums2[right]; 
                right++;
            }
            i++; 
        }
        
        while (left < m) {
            res[i] = nums1[left];
            left++;
            i++;
        }
        
        while (right < n) {
            res[i] = nums2[right];
            right++;
            i++;
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = res[k];
        }
    }
}
