class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] state = new boolean[101];
        for(int x : bulbs){
            state[x] = !state[x];
        }
        for(int i = 1; i <= 100; i++){
            if(state[i]){
                list.add(i);
            }
        }
        return list;
    }
}
