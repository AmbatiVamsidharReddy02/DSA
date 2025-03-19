class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // Validate current node's value
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Check the left subtree and right subtree
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}