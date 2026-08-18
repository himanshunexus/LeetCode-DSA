class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num , 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int var : nums2){
            if(map.containsKey(var) && map.get(var) > 0){
                set.add(var);
                map.put(var,map.get(var) - 1);
            }
        }

        int[] res = new int[set.size()];
        
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;

    }
}
