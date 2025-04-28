class Solution {
    public int longestOnes(int[] nums, int k) {
    int left = 0, right = 0, zerosCount = 0, maxLength = 0;
    while (right < nums.length) {
        // Extend the window with the `right` pointer
        if (nums[right] == 0) zerosCount++;

        // If zeros in the window exceed k, shrink from the left
        while (zerosCount > k) {
            if (nums[left] == 0) zerosCount--;
            left++;
        }
        // Calculate the maximum length of valid subarray so far
        maxLength = Math.max(maxLength, right - left + 1);
        right++;
    }
    return maxLength;
}
}