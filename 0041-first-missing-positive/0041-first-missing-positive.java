class Solution {
    public int firstMissingPositive(int[] nums) {
        // [3, 4, -1, 1]
        // [3, 4, 0, 1]
        // [3, 4, 99, 1]
        // [1, 2, 3, 4]
        // [-3, 4, -99, -1]

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i])>nums.length){
                continue;
            }

            if(nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1] *= -1;

            }   
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return nums.length+1;
    }
}