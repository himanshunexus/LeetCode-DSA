class Solution {
    public boolean stoneGameIX(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        
        for (int st : stones) {
            map.put(st % 3, map.get(st % 3) + 1);
        }
        
        map.put(0, map.get(0) % 2);
        
        if (map.get(1) == 0 && map.get(2) == 0) {
            return false;
        }
        
        int sCount = Math.min(map.get(1), map.get(2));
        int lCount = Math.max(map.get(1), map.get(2));
        
        if (map.get(0) == 0) {
            return sCount != 0;
        }
        return lCount > sCount + 2;
    }
}
