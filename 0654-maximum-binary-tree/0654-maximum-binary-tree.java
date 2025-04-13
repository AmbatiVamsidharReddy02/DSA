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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Start the recursive tree construction.
        return construct(nums, 0, nums.length);
    }
    
    private TreeNode construct(int[] nums, int left, int right) {
        // If the array slice is empty, return null.
        if (left == right) {
            return null;
        }
        
        // Find the index of the maximum element.
        int maxIndex = maxIndex(nums, left, right);
        
        // Create the root node with the maximum value.
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        // Recursively construct the left subtree.
        root.left = construct(nums, left, maxIndex);
        
        // Recursively construct the right subtree.
        root.right = construct(nums, maxIndex + 1, right);
        
        // Return the constructed node.
        return root;
    }
    
    private int maxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}