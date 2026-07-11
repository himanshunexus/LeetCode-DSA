class MyCalendarTwo {
    private TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);

        int count = 0;
        for (int val : events.values()) {
            count += val;
            if (count >= 3) {
                events.put(start, events.get(start) - 1);
                events.put(end, events.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
