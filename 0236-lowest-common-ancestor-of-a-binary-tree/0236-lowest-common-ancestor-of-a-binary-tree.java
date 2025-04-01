public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case:
        if (root == null || root == p || root == q) {
            return root;
        }

        // Perform recursive search in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Perform recursive search in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both calls returned non-null, current node is LCA
        if (left != null && right != null) {
            return root;
        }

        // If one of them is non-null, return it as potential LCA
        return left != null ? left : right;
    }
}