class Solution {
    public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2; // avoid potential overflow
        // Check if mid is the target
        if (nums[mid] == target) {
            return mid;
        }
        // Move right if target is greater than mid value
        else if (nums[mid] < target) {
            left = mid + 1;
        }
        // Move left if target is less than mid value
        else {
            right = mid - 1;
        }
    }
    // left is the position where target should be inserted
    return left;
}
}