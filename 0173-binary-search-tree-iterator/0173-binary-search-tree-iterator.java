class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // Initialize the stack and start from the root
        stack = new Stack<TreeNode>();
        // Push the leftmost path to the stack
        pushLeft(root);
    }
    
    private void pushLeft(TreeNode node) {
        // Push all nodes from the current path to the stack
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    // Returns the next smallest number
    public int next() {
        // Next node is the top of the stack
        TreeNode nextNode = stack.pop();
        // If it has a right subtree, push all left nodes from the right subtree
        if (nextNode.right != null) {
            pushLeft(nextNode.right);
        }
        return nextNode.val;
    }
    
    // Returns whether we have a next smallest number
    public boolean hasNext() {
        // Check if the stack is not empty
        return !stack.isEmpty();
    }
}