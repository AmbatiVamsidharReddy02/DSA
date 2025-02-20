class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int index = 0;
    while (index < heights.length) {
        // If this bar is higher than the bar at the stack's top index, push it to the stack
        if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
            stack.push(index++);
        } else {
            // Pop the top
            int top = stack.pop();
            // Calculate the area with heights[top] as the smallest (height)
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
    }

    // Remaining bars in stack
    while (!stack.isEmpty()) {
        int top = stack.pop();
        int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
        maxArea = Math.max(maxArea, area);
    }

    return maxArea;
    }
}