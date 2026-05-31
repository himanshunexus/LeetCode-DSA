class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int i : asteroids){
            if(i > mass) return false;
            else if(mass >= 1e5) return true;
            mass += i;
        }
        return true;
    }
}
