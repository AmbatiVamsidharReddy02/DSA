class Solution {
    public int maxSubArray(int[] nums) {
        int mSum =  Integer.MIN_VALUE;
        int lSum = 0;
        for(int num: nums){
            lSum += num;
            mSum = Math.max(mSum, lSum);

            if(lSum< 0){
                lSum = 0;
            }
        }
        return mSum;
    }
}