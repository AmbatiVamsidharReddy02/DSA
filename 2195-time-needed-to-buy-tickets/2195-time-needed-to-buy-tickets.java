public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        
        // Iterate over each person in the queue
        for (int i = 0; i < tickets.length; i++) {
            // Calculate time:
            // If this person is at or before k, consider that they can afford k decrements
            // if i > k they cannot use more than the number of the k-th ticket count
            time += (i <= k) ? Math.min(tickets[i], tickets[k]) : Math.min(tickets[i], tickets[k] - 1);
        }
        
        return time;
    }
}