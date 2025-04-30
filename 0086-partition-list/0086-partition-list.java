class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Partition list into less and greater lists
        while (head != null) {
            if (head.val < x) {
                // Append to less list
                less.next = head;
                less = less.next;
            } else {
                // Append to greater list
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Important: break any existing pointers to ensure no cycles
        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;
    }
}