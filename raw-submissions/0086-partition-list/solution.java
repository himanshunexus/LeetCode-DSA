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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode temp1 = dummyNode1;
        ListNode temp2 = dummyNode2;
        ListNode temp = head;
        while(temp != null){
            if(temp.val<x){
                temp1.next=temp;
                temp1=temp1.next;
            }
            else{
                temp2.next=temp;
                temp2=temp2.next;
            }
            temp = temp.next;
        }
        temp1.next = dummyNode2.next;
        temp2.next=null;
        return dummyNode1.next;
    }
}
