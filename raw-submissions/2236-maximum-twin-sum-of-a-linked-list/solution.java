/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr =head;
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }
        int len = list.size()-1;
        int i=0;
        int j=len;
        int sum=0;
        int maxSum = 0;

        while(i<j){
            sum = list.get(i) + list.get(j);
            maxSum = Math.max(maxSum,sum);
            i++;
            j--;
        }
        return maxSum;
    }
}
