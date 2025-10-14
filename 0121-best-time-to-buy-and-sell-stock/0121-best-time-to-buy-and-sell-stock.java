class Solution {
    public int maxProfit(int[] nums) {
        int max = 0;
        int minValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (minValue > nums[i]) {
                minValue = nums[i];
            }
            if (nums[i] - minValue > 0) {
                max = Math.max(nums[i] - minValue, max);
            }
        }
        return max;
    }
}