class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int carry=0;
        int len = num.length;
        for(int i= len -1; i>=0;i--){
            int digitK = k%10;
            int sum = digitK + num[i] + carry;
            list.add(sum%10);
            carry = sum/10;
            k/=10;
        }
        while(k>0){
            int sum = (k%10)+carry;
            list.add(sum%10);
            carry = sum/10;
            k/=10;

        }
        if(carry > 0){
            list.add(carry);
        }
        Collections.reverse(list);
        return list;
    }
}
