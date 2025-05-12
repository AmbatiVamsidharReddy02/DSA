import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;

        for (int[] point : points) {
            int xj = point[0];
            int yj = point[1];

            // Remove outdated points from the deque
            while (!deque.isEmpty() && xj - deque.peekFirst()[1] > k) {
                deque.pollFirst();
            }

            // Calculate potential max with the deque's first element
            if (!deque.isEmpty()) {
                maxValue = Math.max(maxValue, yj + xj + deque.peekFirst()[0]);
            }

            // Maintain deque in a descending order of yi - xi
            while (!deque.isEmpty() && yj - xj >= deque.peekLast()[0]) {
                deque.pollLast();
            }

            // Add current point to the deque
            deque.offerLast(new int[]{yj - xj, xj});
        }

        return maxValue;
    }
}