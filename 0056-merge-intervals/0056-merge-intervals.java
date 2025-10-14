class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        // Output: [[1,6],[8,10],[15,18]]
        // Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        // sort the intervals based on the first value of the interval elements
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // now loop thru the array to find the common interval and to join it and add it
        // to result;
        for (int i = 0; i < intervals.length; i++) {
            if (res.size() > 0 && intervals[i][0] <= res.get(res.size() - 1)[1]) {
                // update the resInterval to intervals[i][1]
                // resInterval[1] = intervals[i][1];
                res.get(res.size() - 1)[1] = Math.max(intervals[i][1], res.get(res.size() - 1)[1]);
            } else {
                // just add the interval to res
                System.out.println(Arrays.toString(intervals[i]));
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                // res.forEach(x -> {
                //     x.stream().forEach(System.out::println);
                // });
            }

        }
        return res.toArray(new int[res.size()][]);
    }
}