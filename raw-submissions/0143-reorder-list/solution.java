class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        for (ListNode c = head; c != null; c = c.next) list.add(c);
        
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i++).next = list.get(j);
            if (i == j) break;
            list.get(j--).next = list.get(i);
        }
        if (!list.isEmpty()) list.get(i).next = null;
    }
}
