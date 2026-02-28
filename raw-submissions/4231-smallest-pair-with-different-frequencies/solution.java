class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i);
            for(int j = i +1; j < list.size(); j++){
                int y = list.get(j);
                if(!freq.get(x).equals(freq.get(y))){
                    return new int[]{x,y};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
