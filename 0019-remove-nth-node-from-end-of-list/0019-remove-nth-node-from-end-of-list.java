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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    // Initialize two pointers both at the dummy node
    ListNode slow = dummy;
    ListNode fast = dummy;
    
    // Move fast ahead by n+1 steps to create the required gap
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }
    
    // Move both pointers till fast reaches the end of the list
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    
    // Adjust the pointers to skip the nth node
    slow.next = slow.next.next;
    
    // Return the updated list starting from the node next to dummy
    return dummy.next;
    }
}