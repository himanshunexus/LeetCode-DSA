class Solution {
    public int maxProduct(int[] nums) {
        int prod =nums[0];
        int maxProd = nums[0];
        int prodN =nums[0];
        for(int i =1;i<nums.length;i++){
            int curr = nums[i];

            if(curr < 0){
                int temp = prod;
                prod = prodN;
                prodN = temp;
            }
           
            prod = Math.max(curr, prod * curr);
            prodN = Math.min(curr, prodN * curr);

            maxProd = Math.max(maxProd, prod);
        }
        return maxProd;
    }
}
