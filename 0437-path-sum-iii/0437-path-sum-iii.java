class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // Initialize with base case
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;
        
        // Update the current prefix sum
        currentSum += node.val;
        
        // Calculate the number of valid paths ending at the current node
        int numPathsToCurrent = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        
        // Update the map for the current prefix sum
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        
        // Recur for left and right subtrees and accumulate results
        int result = numPathsToCurrent + 
                     dfs(node.left, currentSum, targetSum, prefixSumCount) +
                     dfs(node.right, currentSum, targetSum, prefixSumCount);
        
        // Backtrack to ensure the prefixSumCount is correctly maintained
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return result;
    }
}