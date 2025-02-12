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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k==1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode start = head;
        ListNode curr = head;
        ListNode lastKthIndex = null;
        // move fastPointer k positions further
        ListNode fast = head;
        int i = 0;
        while (i < k && fast != null) {
            fast = fast.next;
            i++;
        }

        if (fast == null && i < k) {
            // we don't have k group nodes return the head;
            return head;
        }

        ListNode next = head.next;

        if (fast == null && i == k) {
            // simply reverse the list and return head;
            while (curr != fast && next != null) {
                curr.next = temp;
                temp = curr;
                curr = next;
                next = next.next;
            }
            curr.next = temp;
            head.next = null;
            head = curr;
        }
        while (fast != null) {
            while (curr != fast) {
                curr.next = temp;
                temp = curr;
                curr = next;
                next = next.next;
            }

            if (curr == fast) {
                // we reversed a group now we need to attach them.
                start.next = curr;

                i = 0;
                while (i < k && fast != null) {
                    fast = fast.next;
                    i++;
                }

                if (fast == null) {
                    // we don't have k group nodes return the head;
                    // link them before we break the loop.
                    if (i <= k) {
                        if (lastKthIndex == null) {
                            head = temp;
                        }
                        if (lastKthIndex != null) {
                            lastKthIndex.next = temp;
                        }
                        if (i == k) {
                            lastKthIndex = start;
                            start = curr;
                            temp = dummy;
                            System.out.println(curr.val + " " + " " + temp.val + " " + start.val + " " + next.val + " ");
                            while (curr != fast && next != null) {
                                curr.next = temp;
                                temp = curr;
                                curr = next;
                                next = next.next;
                            }
                            curr.next = temp;
                            start.next = null;
                            if (lastKthIndex != null) {
                                lastKthIndex.next = curr;
                            }
                        }
                        System.out.println(curr.val + " " + " " + temp.val + " " + start.val + " ");
                        break;
                    }
                }
                if (lastKthIndex == null) {
                    head = temp;
                }
                if (lastKthIndex != null) {
                    lastKthIndex.next = temp;
                }
                lastKthIndex = start;
                start = curr;
                temp = dummy;
            }
        }

        return head;
    }
}
