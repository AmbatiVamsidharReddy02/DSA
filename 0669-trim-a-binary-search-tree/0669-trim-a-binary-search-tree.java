class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Edge case: if the tree is empty
        if (root == null) {
            return null;
        }

        // Adjust the root to be within range
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else if (root.val > high) {
                root = root.left;
            }
        }

        // Use a stack to perform DFS iteratively
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                // Trim the left subtree if necessary
                while (node.left != null && node.left.val < low) {
                    node.left = node.left.right;
                }

                // Trim the right subtree if necessary
                while (node.right != null && node.right.val > high) {
                    node.right = node.right.left;
                }

                // Push children onto the stack to continue trimming other nodes
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return root;
    }
}