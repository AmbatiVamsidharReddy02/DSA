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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // stringfying the number won't work as the lists are two long to be represented as integers.
        int carry = 0;

        ListNode one = l1;
        ListNode two = l2;
        ListNode dummy = new ListNode(0);
        ListNode resultList = dummy;
        while (one != null && two != null) {
            int result = one.val + two.val + carry;

            int digit = result % 10;
            carry = result / 10;
            resultList.next = new ListNode(digit);
            one = one.next;
            two = two.next;
            resultList = resultList.next;
        }

        while (one != null) {
            // add remaining digits of null to result;
            int result = one.val + carry;

            int digit = result % 10;
            carry = result / 10;
            resultList.next = new ListNode(digit);
            one = one.next;
            resultList = resultList.next;
        }

        while (two != null) {
            int result = two.val + carry;

            int digit = result % 10;
            carry = result / 10;
            resultList.next = new ListNode(digit);
            two = two.next;
            resultList = resultList.next;
        }

        if (carry!=0) {
            resultList.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
