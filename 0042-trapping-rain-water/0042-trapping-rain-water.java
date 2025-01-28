class Solution {
    public int trap(int[] height) {
        int n = height.length;
    if (n == 0) return 0;
    
    int left = 0, right = n - 1;
    int leftMax = 0, rightMax = 0;
    int trappedWater = 0;
    
    while (left < right) {
        // Move the pointer with the smaller height
        if (height[left] < height[right]) {
            // If left is smaller, check against leftMax
            if (height[left] > leftMax) {
                leftMax = height[left];
            } else {
                trappedWater += leftMax - height[left];
            }
            left++;
        } else {
            // If right is smaller, check against rightMax
            if (height[right] > rightMax) {
                rightMax = height[right];
            } else {
                trappedWater += rightMax - height[right];
            }
            right--;
        }
    }

        return trappedWater;
    }
}