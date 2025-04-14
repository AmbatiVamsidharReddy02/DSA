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
    if (head == null || head.next == null || k == 0) return head;

    // Find the length of the linked list
    ListNode tail = head;
    int length = 1;
    while (tail.next != null) {
        tail = tail.next;
        length++;
    }
    
    // Make it a circular list
    tail.next = head;
    
    // Calculate the break point
    k = k % length;
    int stepsToNewHead = length - k;
    ListNode newTail = tail;
    
    // Find the position to break the circle
    while (stepsToNewHead-- > 0) {
        newTail = newTail.next;
    }
    
    // Make new head and break the circle
    ListNode newHead = newTail.next;
    newTail.next = null;

    return newHead;
}
}