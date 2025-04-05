class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeightAndDiameter(root);
        return maxDiameter;
    }

    private int calculateHeightAndDiameter(TreeNode node) {
        if (node == null) return 0;
        // Calculate the heights of left and right subtrees
        int leftHeight = calculateHeightAndDiameter(node.left);
        int rightHeight = calculateHeightAndDiameter(node.right);

        // Calculate the diameter passing through this node
        int diameterThroughNode = leftHeight + rightHeight;
        
        // Update the maximum diameter
        maxDiameter = Math.max(maxDiameter, diameterThroughNode);

        // Return height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}