import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check for any triple booking that would result from this new event
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false; // This means there would be a triple booking
            }
        }

        // Update overlaps list with new overlaps caused by the new event
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});
            }
        }

        // Finally add this event to the list of bookings
        bookings.add(new int[]{start, end});
        return true;
    }
}