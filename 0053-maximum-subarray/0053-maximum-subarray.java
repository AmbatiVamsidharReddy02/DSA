class Solution {
    public int maxSubArray(int[] nums) {
        // if the current sum is less than the currEle restart the subarray from the
        // currEle.
        // compare max with (max, currSum, CurrEle) use greater value as max
        int max = Integer.MIN_VALUE;
        int currSubSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSubSum + nums[i] >= nums[i]) {
                currSubSum = currSubSum + nums[i];
            } else {
                currSubSum = nums[i];
            }
            max = Math.max(max, Math.max(nums[i], currSubSum));
        }
        return max;
    }
}