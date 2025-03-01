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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {

        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        // constructed a array for easier processing. 
        TreeNode root = constructTree(0, list.size()-1);
        return root;
    }

    public TreeNode constructTree(int start, int end){
        if(start>end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = constructTree(start, mid-1);
        root.right = constructTree(mid+1, end);
        return root;
    }
}