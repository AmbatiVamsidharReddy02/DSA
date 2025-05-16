import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            
            // Only consider jumps that require climbing up
            if (diff > 0) {
                pq.add(diff);  // Track this jump in the heap
                
                // If bricks are insufficient, replace the largest used bricks with a ladder
                if (pq.size() > ladders) {
                    bricks -= pq.poll();  // Remove the smallest jump once ladders replace enough bricks
                }
                
                // If bricks run out, return the current position
                if (bricks < 0) {
                    return i;
                }
            }
        }
        return heights.length - 1;
    }
}