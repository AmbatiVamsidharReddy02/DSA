class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;
        for(int i=0;i<nums.length;i++){
            if(currSum<0){
                currSum = 0;
            }
            currSum = currSum + nums[i];
            max = Math.max(currSum, Math.max(max, nums[i]));
        }
        return max;

    }
}