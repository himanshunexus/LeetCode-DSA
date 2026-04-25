class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean exploded = false;
            while (!list.isEmpty() && list.get(list.size() - 1) > 0 && current < 0) {
                int last = list.get(list.size() - 1);
                if (Math.abs(last) < Math.abs(current)) {
                    list.remove(list.size() - 1);
                    continue;
                } else if (Math.abs(last) == Math.abs(current)) {
                    list.remove(list.size() - 1);
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }

            if (!exploded) {
                list.add(current);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
