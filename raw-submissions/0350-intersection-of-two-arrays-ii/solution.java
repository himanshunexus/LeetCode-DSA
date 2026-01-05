class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int var : nums2){
            if(map.containsKey(var) && map.get(var)>0){
                list.add(var);
                map.put(var,map.get(var)-1);
            }
        }
        int[] res = new int[list.size()];

        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
