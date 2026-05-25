class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> pq = new LinkedList<>();
        for(int i = 0; i < n; i++){
            pq.add(i);
        }
        int[] res = new int[n];
        for (int card : deck) {
            res[pq.poll()] = card;
            if (!pq.isEmpty()) {
                pq.add(pq.poll());
            }
        }
        return res;
    }
}
