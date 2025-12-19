class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=left;i<=right;i++){
        int num = i;
        boolean flag=true;
        
        while(num!=0){
            int rem = num %10;
            if(rem == 0 || i%rem!=0){
                flag=false;
                break;
            }
            num/=10;
        }
        if(flag)
        list.add(i);
        }

        return list;
    }
}
