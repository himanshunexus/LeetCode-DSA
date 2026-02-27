class MyCalendar {
    List<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] event : calendar) {
            int start = event[0];
            int end = event[1];
            if (startTime < end && endTime > start) {
                return false;
            }
        }
        int[] newBooking = new int[]{startTime, endTime};
        calendar.add(newBooking);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
