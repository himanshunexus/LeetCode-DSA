class Solution {
    static class NodePair {
        ListNode node;
        int frequency;

        NodePair(ListNode node, int frequency) {
            this.node = node;
            this.frequency = frequency;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<NodePair> pq = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(new NodePair(head, 1));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            NodePair top = pq.poll();
            ListNode node = top.node;

            current.next = node;
            current = current.next;

            if (node.next != null) {
                pq.add(new NodePair(node.next, 1));
            }
        }

        return dummy.next;
    }
}
