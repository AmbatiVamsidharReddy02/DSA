import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Increment the count of ongoing events at 'start' and decrement at 'end'
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int activeBookings = 0;
        // Iterate through the times to check active bookings
        for (int delta : calendar.values()) {
            activeBookings += delta;
            if (activeBookings >= 3) {  // Triple booking occurs
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                return false;
            }
        }
        return true;  // No triple booking, booking is successful
    }
}