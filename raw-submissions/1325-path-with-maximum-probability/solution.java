class Pair implements Comparable<Pair> {
    int node;
    double prob;

    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
    public int compareTo(Pair other) {
        return Double.compare(other.prob, this.prob);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            double p = current.prob;

            if (u == end) return p;
            if (p < maxProb[u]) continue;

            for (Pair neighbor : adj.get(u)) {
                if (maxProb[u] * neighbor.prob > maxProb[neighbor.node]) {
                    maxProb[neighbor.node] = maxProb[u] * neighbor.prob;
                    pq.add(new Pair(neighbor.node, maxProb[neighbor.node]));
                }
            }
        }

        return 0.0;
    }
}
