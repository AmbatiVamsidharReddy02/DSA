public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Call the helper function with initial indices
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, 
                               int preStart, int preEnd, int inStart, int inEnd) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the root element index in inorder array
        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRootIndex = i;
                break;
            }
        }

        // Calculate the size of the left subtree
        int leftTreeSize = inRootIndex - inStart;

        // Recursive construction of left and right subtrees
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftTreeSize, inStart, inRootIndex - 1);
        root.right = buildTree(preorder, inorder, preStart + leftTreeSize + 1, preEnd, inRootIndex + 1, inEnd);

        return root;
    }
}