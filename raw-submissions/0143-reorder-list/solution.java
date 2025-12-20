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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode midPtr = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode fwd = null;

        while(midPtr!=null){
            fwd = midPtr.next;
            midPtr.next = prev;
            prev = midPtr;
            midPtr = fwd;
        }
        ListNode first = head;
        ListNode second = prev;

        while(second !=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }

    }
}
