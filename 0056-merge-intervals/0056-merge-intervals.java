class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        // Output: [[1,6],[8,10],[15,18]]
        // Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        // sort the intervals based on the first value of the interval elements
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // now loop thru the array to find the common interval and to join it and add it
        // to result;

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap condition: current start <= previous end
            if (intervals[i][0] <= prev[1]) {
                // Merge intervals
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                // No overlap, add previous interval to result
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev); // Add the last interval
        return merged.toArray(new int[merged.size()][]);
    }
}