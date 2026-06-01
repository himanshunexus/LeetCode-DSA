class Solution {
    public int minimumCost(int[] cost) {
        int price = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int item : cost){
            pq.add(item);
        }
        while(!pq.isEmpty()){
            int candyOne = pq.poll();
            int candyTwo = 0;
            if(!pq.isEmpty())
                candyTwo = pq.poll();
            if(!pq.isEmpty())
                pq.poll();
            price += candyOne + candyTwo;
        }
        return price;
    }
}
