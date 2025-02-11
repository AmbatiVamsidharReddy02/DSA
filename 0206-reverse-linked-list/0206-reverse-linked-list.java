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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        ListNode curr = head;
        ListNode next = head.next;

        while(next!=null){
            // System.out.println(curr.val + " "+temp.val+" "+next.val+" ");
            curr.next = temp;
            temp = curr;
            curr = next;
            next = next.next;
        }
        curr.next = temp;
        head.next = null;
        return curr;
    }
}