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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int listLen = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            listLen++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int toRotateFromEnd = k % listLen;
        if(toRotateFromEnd==0){
            return head;
        }
        ListNode fast = dummy.next;
        ListNode slow = dummy.next;

        for (int j = 0; j < toRotateFromEnd; j++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        temp = slow;
        while(temp.next!=null){
            temp = temp.next;
        }

        ListNode lastElement = temp;

        // lastElement.next = dummy.next;
        // dummy.next = lastElement;
        // slow.next = null;

        
        dummy.next = slow.next;
        temp.next = head;
        slow.next = null;
        return dummy.next;
    }
}
