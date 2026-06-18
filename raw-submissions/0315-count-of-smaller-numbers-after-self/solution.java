class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] tree = new int[20002];
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i] + 10001;
            int sum = 0;
            for (int j = val - 1; j > 0; j -= j & -j) sum += tree[j];
            res[i] = sum;
            for (int j = val; j < 20002; j += j & -j) tree[j]++;
        }
        return Arrays.asList(res);
    }
}
