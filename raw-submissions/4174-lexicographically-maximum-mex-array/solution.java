class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x , map.getOrDefault(x,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < n){
            int mex = 0;
            while(map.getOrDefault(mex , 0) > 0){
                mex++;
            }
        if(mex == 0){
            ans.add(0);
            map.put(nums[i],map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0){
                map.remove(nums[i]);
            }
            i++;
            continue;
        }
        Set<Integer> need = new HashSet<>();
        for(int x = 0; x < mex; x++){
            need.add(x);
        }
        int j = i;
        while(!need.isEmpty()){
            int val = nums[j];
            if(need.contains(val)){
                need.remove(val);
            }
            map.put(val,map.get(val) - 1);
            if(map.get(val) == 0){
                map.remove(val);
            }
            j++;
        }
        ans.add(mex);
        i = j;
    }
    int[] res = new int[ans.size()];
    for(int k = 0; k < ans.size(); k++){
        res[k] = ans.get(k);
    }
    return res;
    }
}
