class Pair implements Comparable<Pair> {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
    public int compareTo(Pair other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times) {
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.distance;

            if (d > dist[u]) continue;

            for (Pair edge : adj.get(u)) {
                if (dist[u] + edge.distance < dist[edge.node]) {
                    dist[edge.node] = dist[u] + edge.distance;
                    pq.add(new Pair(edge.node, dist[edge.node]));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
