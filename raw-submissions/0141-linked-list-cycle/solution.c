/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
    struct ListNode *slow = head, *fast = head;
    while (fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) return true;
    }
    return false;
}

struct ListNode* newNode(int val) {
    struct ListNode* temp = (struct ListNode*)malloc(sizeof(struct ListNode));
    temp->val = val;
    temp->next = NULL;
    return temp;

    
}
