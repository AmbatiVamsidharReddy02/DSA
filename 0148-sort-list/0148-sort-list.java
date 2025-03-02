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
        // Base case: If the list is empty or has a single node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into halves using slow and fast pointers
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Disconnect the first half from the second half
        prev.next = null;

        // Step 2: Sort each half
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(slow);

        // Step 3: Merge the sorted halves
        return merge(leftHalf, rightHalf);
    }

    // Function to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        // At the end of while, one of the lists could have remaining nodes
        current.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}