class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        int[] freq = new int[n + 1];  

      
        for (int num : nums) {
            freq[num]++;
        }

      
        List<Integer> missing = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) { 
                missing.add(i);
            }
        }

        return missing;
    }
}
