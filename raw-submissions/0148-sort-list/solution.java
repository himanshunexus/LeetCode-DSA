/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
  
        ListNode head1 = head;
        ListNode head2 = slow;
        if (prev != null) {
            prev.next = null; 
        }

 
        head1 = sortList(head1);
        head2 = sortList(head2);
        
     
        return merge(head1, head2);
    }


    private static ListNode merge(ListNode head1, ListNode head2){
        ListNode i = head1;
        ListNode j = head2;
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        

        while(i != null && j != null){
            if(i.val <= j.val){
                k.next = i;
                i = i.next;
            }
            else{
                k.next = j;
                j = j.next;
            }
            k = k.next;
    
        }
        
        if(i != null) {
            k.next = i;
        } else if(j != null) {
            k.next = j;
        }
        
        return dummy.next;
    }
}
