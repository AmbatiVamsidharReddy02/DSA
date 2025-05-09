import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0, right;
        int maxLen = 0;
        
        for (right = 0; right < nums.length; right++) {
            // Maintain decreasing order for maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right])
                maxDeque.pollLast();
            maxDeque.offerLast(right);

            // Maintain increasing order for minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right])
                minDeque.pollLast();
            minDeque.offerLast(right);

            // If the current window doesn't satisfy the condition, slide the window
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                // Remove elements outside the window
                if (maxDeque.peekFirst() < left)
                    maxDeque.pollFirst();
                if (minDeque.peekFirst() < left)
                    minDeque.pollFirst();
            }
            
            // Update max length of satisfying subarray
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}