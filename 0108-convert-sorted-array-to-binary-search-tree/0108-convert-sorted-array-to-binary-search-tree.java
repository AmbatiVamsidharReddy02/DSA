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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null; // base case
        }
        
        int mid = left + (right - left) / 2; // find middle element
        
        TreeNode node = new TreeNode(nums[mid]); // create the root node
        
        node.left = helper(nums, left, mid - 1); // recursively create left subtree
        node.right = helper(nums, mid + 1, right); // recursively create right subtree
        
        return node; // return the constructed node
    }
}