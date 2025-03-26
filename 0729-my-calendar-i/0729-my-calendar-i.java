import java.util.TreeMap;

class MyCalendar {
    // TreeMap to store the intervals with key as the start time and value as end time
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        // Initialize the TreeMap
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Find the entry with largest key less than or equal to the start of the new interval
        Integer prev = calendar.floorKey(start);
        // Find the entry with the smallest key greater than the start
        Integer next = calendar.ceilingKey(start);

        // If the new interval overlaps with previous or next interval, return false
        if ((prev != null && calendar.get(prev) > start) || (next != null && next < end)) {
            return false;
        }
        
        // Otherwise, add the new interval
        calendar.put(start, end);
        return true;
    }
}