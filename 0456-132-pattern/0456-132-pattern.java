class Solution {
    public boolean find132pattern(int[] nums) {
    if (nums.length < 3) return false;
    
    int third = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    
    for (int i = nums.length - 1; i >= 0; i--) {
        // Check if the current number can be nums[i] in 132 pattern
        if (nums[i] < third) {
            return true;
        }
        
        // Maintain the stack such that any number in it is a potential nums[j]
        // And update third to be the maximum valid nums[k]
        while (!stack.isEmpty() && nums[i] > stack.peek()) {
            third = stack.pop();
        }
        
        // Push the current number as potential nums[j]
        stack.push(nums[i]);
    }
    
    return false;
}
}