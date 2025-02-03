class Solution {

    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                result = Math.max(min, Math.max(max,result));
                min = 0;
                max = 0;
            } else {
                int currMin = min;
                int currMax = max;
                result = Math.max(min, Math.max(max, result));
                min = Math.min(nums[i], Math.min(nums[i] * currMin, nums[i] * currMax));
                max = Math.max(nums[i], Math.max(nums[i] * currMin, nums[i] * currMax));
            }
        }
        return Math.max(min, Math.max(max, result));
    }
}
