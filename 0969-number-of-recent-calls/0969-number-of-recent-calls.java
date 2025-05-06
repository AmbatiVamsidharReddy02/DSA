import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> calls;

    public RecentCounter() {
        // Initialize the queue to store timestamps
        calls = new LinkedList<>();
    }

    public int ping(int t) {
        // Add current timestamp to the queue
        calls.offer(t);
        // Remove timestamps older than (t - 3000)
        while (calls.peek() < t - 3000) {
            calls.poll();
        }
        // The size of the queue represents the number of valid recent calls
        return calls.size();
    }
}