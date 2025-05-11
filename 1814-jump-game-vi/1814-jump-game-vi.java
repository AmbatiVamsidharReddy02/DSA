import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int maxResult(int[] nums, int k) {
        // Deque to keep indices of potential max scores in window
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0); // Initialize with the first element
        
        // DP array to store maximum score to reach each index
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Remove indices that are out of the sliding window
            while (!deque.isEmpty() && deque.peek() < i - k) {
                deque.poll();
            }
            
            // Calculate the maximum score for current index
            dp[i] = nums[i] + dp[deque.peek()];
            
            // Maintain the deque for potential max scores, removing less useful indices
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offer(i);
        }

        return dp[nums.length - 1];
    }
}