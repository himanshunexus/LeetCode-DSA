class Solution {
    public int maximumLengthSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            HashMap<Character,Integer> map = new HashMap<>();
            for(int k = i; k < n; k++){
                map.put(arr[k] , map.getOrDefault(arr[k] , 0) + 1);
                count++;
                if(map.get(arr[k]) > 2){
                    break;
                }
                ans = Math.max(count , ans);
            }
        }
        return ans;
    }
}
