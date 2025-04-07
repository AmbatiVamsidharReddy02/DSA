class Solution {
    private int maxSum = Integer.MIN_VALUE; // Global variable to track the maximum path sum

    public int maxPathSum(TreeNode root) {
        calculateMaxGain(root);
        return maxSum;
    }

    private int calculateMaxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Find maximum path sum starting from the left and right child
        // If the path sum is negative, discard it by taking max with 0
        int leftGain = Math.max(calculateMaxGain(node.left), 0);
        int rightGain = Math.max(calculateMaxGain(node.right), 0);

        // Calculate the new possible maximum path sum with current node as the highest node
        int currentMaxPath = node.val + leftGain + rightGain;

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, currentMaxPath);

        // Return the node's gain as part of the path; max path sum including this node
        return node.val + Math.max(leftGain, rightGain);
    }
}