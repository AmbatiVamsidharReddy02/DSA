class Solution {
    public int[] canSeePersonsCount(int[] heights) {
    int n = heights.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();

    // Traverse the queue from right to left
    for (int i = n - 1; i >= 0; i--) {
        int visibleCount = 0;

        // Remove people who are shorter and therefore not visible
        while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
            stack.pop();
            visibleCount++;
        }

        // If any people remain, the current person's view will also include the next taller person
        if (!stack.isEmpty()) {
            visibleCount++;
        }
        
        result[i] = visibleCount;  // Store result for current person
        stack.push(i);  // Add current person to stack
    }

    return result;
}
}