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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode temp1 = dummyNode1;
        ListNode temp2 = dummyNode2;
        ListNode temp = head;
        int count=1;
        while(temp!=null){
            if(count % 2 !=0){
                temp1.next = temp;
                temp1=temp1.next;
                count++;
            }
            else{
                temp2.next=temp;
                temp2=temp2.next;
                count++;
            }
            temp=temp.next;
        }
            temp1.next =dummyNode2.next;
            temp2.next = null;
            return dummyNode1.next;
    }
}
