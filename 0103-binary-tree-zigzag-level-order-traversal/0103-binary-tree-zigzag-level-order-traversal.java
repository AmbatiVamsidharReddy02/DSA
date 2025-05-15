import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // Two stacks for alternating levels
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currentLevel.push(root);
        boolean leftToRight = true;
        
        List<Integer> currentList = new ArrayList<>();
        
        while (!currentLevel.isEmpty()) {
            TreeNode currentNode = currentLevel.pop();
            currentList.add(currentNode.val);
            
            // Add children to nextLevel stack in the correct order
            if (leftToRight) {
                if (currentNode.left != null) {
                    nextLevel.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.push(currentNode.right);
                }
            } else {
                if (currentNode.right != null) {
                    nextLevel.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    nextLevel.push(currentNode.left);
                }
            }
            
            if (currentLevel.isEmpty()) {
                // End of current level
                result.add(new ArrayList<>(currentList));
                currentList.clear();
                // Swap stacks
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        
        return result;
    }
}