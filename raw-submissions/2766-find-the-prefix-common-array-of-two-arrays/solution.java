class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length , commonCount = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
            if(map.get(A[i]) == 2){
                commonCount++;
            }
            map.put(B[i], map.getOrDefault(B[i],0) + 1);
            if(map.get(B[i]) == 2){
                commonCount++;
            }
            res[i] = commonCount;
        }
        return res;
    }
}
