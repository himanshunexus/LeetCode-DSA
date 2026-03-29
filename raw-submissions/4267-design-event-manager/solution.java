class EventManager {
    private PriorityQueue<int[]> pq;
    private Map<Integer, Integer> map;

    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; 
            return a[1] - b[1]; 
        });

        map = new HashMap<>();

        for (int[] event : events) {
            int id = event[0];
            int priority = event[1];
            map.put(id, priority);
            pq.offer(new int[]{priority, id});
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        if (!map.containsKey(eventId)) return;
        map.put(eventId, newPriority);
        pq.offer(new int[]{newPriority, eventId}); 
    }

    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0];
            int id = top[1];

            if (map.containsKey(id) && map.get(id) == priority) {
                map.remove(id);
                return id;
            }
        }
        return -1;
    }
}
