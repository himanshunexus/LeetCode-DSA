class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        long ans = 0;
        int cur = 0;

        for (int x : nums) {
            cur ^= x;
            int count = map.getOrDefault(cur, 0);
            ans += count;
            map.put(cur, count + 1);
        }
        return ans;
    }
}
