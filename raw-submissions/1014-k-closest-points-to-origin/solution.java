class Solution {

    private int euclideanDistance(int x, int y){
        return x*x + y*y; 
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> euclideanDistance(b[0], b[1]) - euclideanDistance(a[0], a[1]));

        int[][] res = new int[k][2];
        int n = points.length;

        for(int i = 0; i < n; i++){
            pq.add(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
}

