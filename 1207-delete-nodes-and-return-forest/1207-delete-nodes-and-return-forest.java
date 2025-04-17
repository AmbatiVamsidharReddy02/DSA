import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> deleteSet = new HashSet<>();
        
        // Populate the HashSet with nodes to delete for an O(1) lookup.
        for (int val : to_delete) {
            deleteSet.add(val);
        }
        
        // Helper function to perform DFS and manage the forest list.
        helper(root, true, deleteSet, forest);
        
        return forest;
    }
    
    private TreeNode helper(TreeNode node, boolean isRoot, Set<Integer> deleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        
        // Determine if the current node needs to be deleted.
        boolean deleted = deleteSet.contains(node.val);
        
        if (isRoot && !deleted) {
            forest.add(node);
        }
        
        // Recursively process child nodes, determining new roots based on 'deleted' status.
        node.left = helper(node.left, deleted, deleteSet, forest);
        node.right = helper(node.right, deleted, deleteSet, forest);

        // Return null if node is deleted, otherwise return the current node.
        return deleted ? null : node;
    }
}