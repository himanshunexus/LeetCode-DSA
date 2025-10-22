/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        int countA=0;
        while(tempA!=null){
            countA++;
            tempA=tempA.next;
        }
        int countB=0;
        while(tempB!=null){
            countB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(countA>countB){
            int size=countA-countB;
            for(int i=0;i<size;i++){
                tempA=tempA.next;
            }
        }
        else{
            int size=countB-countA;
            for(int i=0;i<size;i++){
                tempB=tempB.next;
            }
        }
        while(tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA;
    }
}
