class Solution {
    public String trafficSignal(int timer) {
        String ans;
        if(timer == 0) ans = "Green";
        else if(timer == 30) ans = "Orange";
        else if(30 < timer && timer <= 90) ans = "Red";
        else ans = "Invalid";
        return ans;
    }
}
