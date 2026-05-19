class Solution {
    public int findDigit(int num){
        if(num == 0) return 0;
        int maxD = Integer.MIN_VALUE;
        while(num > 0){
            int rem = num % 10;
            maxD = Math.max(maxD , rem);
            num /= 10;
        }
        return maxD;
    }
    
    public int maxSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int maxDigit = findDigit(nums[i]);
            map.put(nums[i] , maxDigit);
        }
        

        int res = -1;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.get(nums[i]).equals(map.get(nums[j]))) {
                    int currentSum = nums[i] + nums[j];
                    if (currentSum > res) {
                        res = currentSum;
                    }
                }
            }
        }
        
        return res;
    }
}
