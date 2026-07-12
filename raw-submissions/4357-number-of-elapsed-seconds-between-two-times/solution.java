class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return convert(endTime) - convert(startTime);
    }
    private int convert(String time){
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        int ss = Integer.parseInt(parts[2]);
        return (hh * 3600) + (mm * 60) + ss;
    }
}
