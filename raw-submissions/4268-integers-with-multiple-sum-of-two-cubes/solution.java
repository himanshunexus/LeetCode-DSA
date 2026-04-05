class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int m = (int)Math.cbrt(n);
        for(int i = 1; i <= m; i++){
            int cbRoot = i * i * i;
            for(int k = i; k <= m; k++){
                int sum = cbRoot + k * k * k;
                if(sum  > n) break;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) >= 2){
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }
}
