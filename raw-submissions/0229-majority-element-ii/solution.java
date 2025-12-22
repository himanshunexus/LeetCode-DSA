class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if (map.get(key) > len / 3){
               list.add(key);
            }
        }
        return list;
    }
}
