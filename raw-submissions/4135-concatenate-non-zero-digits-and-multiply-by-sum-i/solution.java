class Solution {
    public long sumAndMultiply(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0){
            int digit = n % 10;
            if(digit > 0){
                list.add(digit);
            }
            n /= 10;
        }
        long sum = 0;
        for(int z : list){
            sum += z;
        }
        long newN = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            newN = newN * 10 + list.get(i);
        }
        return sum * newN;
    }
}
