class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> res = new LinkedList<>();
        for(int i=1; i<=n; i++){
            res.add(i);
        }
        while(res.size()>1){
            for(int i=1; i<=k-1;i++){
                res.add(res.remove());
            }
            res.remove();
        }
        return res.peek();
    }
}
