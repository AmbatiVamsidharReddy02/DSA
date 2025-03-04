class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] { -1, -1 };
        }

        int low = 0;
        int high = nums.length - 1;
        int start = -1, end = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // need to check it;s start and end.
                // Found target, now expand to find the bounds
                start = mid;
                end = mid;

                // Move in both directions to find the start and end
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                return new int[] { start, end };
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { start, end };
    }
}
