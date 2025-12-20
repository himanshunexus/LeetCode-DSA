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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode resNode = new ListNode(-1);
        ListNode temp1 = dummyNode1;
        ListNode temp2 = dummyNode2;
        ListNode temp = head;

        int count=1;
        while(temp!=null){
            if(count % 2 !=0){
                temp1.next = temp;
                temp1 = temp1.next;
                count++;
            }
            else{
                temp2.next = temp;
                temp2 = temp2.next;
                count++;
            }
            temp = temp.next;
        }
        temp2.next=null;
        temp1.next=null;
        ListNode curr1 = dummyNode2.next; 
        ListNode curr2 = dummyNode1.next; 
        ListNode res = resNode;

        while (curr1 != null && curr2 != null) {
            res.next = curr1;
            curr1 = curr1.next;
            res = res.next;

            res.next = curr2;
            curr2 = curr2.next;
            res = res.next;
        }

        if (curr2 != null) {
            res.next = curr2;
        }
        return resNode.next;
     
    }
}
