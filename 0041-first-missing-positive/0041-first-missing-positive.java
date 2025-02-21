class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < 0 || index >= nums.length || (nums[index]<0 && nums[index]!=Integer.MIN_VALUE)) {
                continue;
            }
            if (nums[index] == 0) {
                nums[index] = Integer.MIN_VALUE;
            } else {
                nums[index] = -1 * nums[index];
            }
        }
        int j = 0;
        while(j<nums.length){
            if(nums[j]>=0){
                break;
            }
            j++;
        }
        return j+1;
    }
}
