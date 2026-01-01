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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // ListNode dummyNode = new ListNode(-1);
        // ListNode temp = dummyNode;
        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sptr = slow;
        ListNode ptr = slow;
        ListNode fwd = null;
        ListNode prev = null;

        while(sptr!=null){
            fwd = sptr.next;
            sptr.next = prev;
            prev = sptr;
            sptr=fwd;
        }
        while (prev != null) {
            if (curr.val != prev.val)
                return false;
            curr = curr.next;
            prev = prev.next;
        }
    return true;

    }
}
