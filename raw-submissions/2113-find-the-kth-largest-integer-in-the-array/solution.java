import java.math.BigInteger;
import java.util.PriorityQueue;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        for (String s : nums) {
            pq.add(new BigInteger(s));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek().toString();
    }
}

