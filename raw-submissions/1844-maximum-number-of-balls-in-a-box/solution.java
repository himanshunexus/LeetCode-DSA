class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int n = highLimit - lowLimit + 1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = lowLimit; i <= highLimit; i++){
            int ele = i;
            int sum = 0;
            while( ele != 0){
                sum += ele%10;
                ele/=10;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(map);
        int max =0;
        for(int i : map.values()){
            max = Math.max(max,i);
        }
        return max;
    }
}
