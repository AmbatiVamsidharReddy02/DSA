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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstPointer = head, secondPointer = head.next;
        ListNode thirdPointer = null;
        ListNode lastVisitedPointer = null;
        if (head.next.next != null) {
            thirdPointer = head.next.next;
        }

        // case for two nodes
        firstPointer.next = thirdPointer;
        secondPointer.next = firstPointer;
        head = secondPointer;
        lastVisitedPointer = firstPointer;

        firstPointer = thirdPointer;
        if (firstPointer!=null && firstPointer.next != null) {
            secondPointer = firstPointer.next;
            if (secondPointer != null) {
                thirdPointer = secondPointer.next;
            } else {
                return head;
            }
        } else {
            return head;
        }

        while (firstPointer.next != null) {
            firstPointer.next = thirdPointer;
            secondPointer.next = firstPointer;
            lastVisitedPointer.next = secondPointer; 
            // secondPointer.next = lastVisitedPointer;
            lastVisitedPointer = firstPointer;
            firstPointer = thirdPointer;
            if (firstPointer!=null && firstPointer.next != null) {
                secondPointer = firstPointer.next;
                if (secondPointer != null) {
                    thirdPointer = secondPointer.next;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return head;
    }
}
