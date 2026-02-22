class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i = 1; i <= 9; i++){
            fact[i] = fact[i - 1] * i;
        }
        int[] freq1 = new int[10];
        int temp = n;
        if(temp == 0) 
            freq1[0]++;
        while(temp > 0){
            freq1[temp % 10]++;
            temp /= 10;
        }
        int sum = 0;
        for(int d = 0; d <= 9; d++){
            sum += freq1[d] * fact[d];
        }
        int[] freq2 = new int[10];
        temp = sum;
        if(temp == 0)
            freq2[0]++;
        while(temp > 0){
            freq2[temp % 10]++;
            temp /= 10;
        }
        for(int i = 0; i < 10; i++){
            if(freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}
