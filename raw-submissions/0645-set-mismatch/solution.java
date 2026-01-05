class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int aSum = n*(n+1)/2;
        int duplicate=0;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                duplicate = num;
            }
            else {
                sum += num;
            }
            map.put(num,map.getOrDefault(num,0)+1);
            
        }
        int[] res = new int[2];
        res[1] = Math.abs(sum - aSum);
        res[0] = duplicate;
        return res;
    }
}
