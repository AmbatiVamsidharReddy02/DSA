import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Sort the deck so we can place cards from smallest to largest
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> indexQueue = new LinkedList<>();
        // Create a queue that holds indices from 0 to n-1
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];
        // For each card in the sorted deck, place it at the first index, then rotate the queue
        for (int card : deck) {
            // Place the current smallest card at the index popped from the queue
            result[indexQueue.poll()] = card;
            // Simulate rotation by moving the next index to the bottom of the queue
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }
        return result;
    }
}