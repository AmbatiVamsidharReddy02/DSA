class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int currEle = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count <= 0) {
                currEle = nums[i];
            }
            if (currEle != nums[i]) {
                count--;
            } else {
                count++;
            }
            
        }
        return currEle;
    }
}