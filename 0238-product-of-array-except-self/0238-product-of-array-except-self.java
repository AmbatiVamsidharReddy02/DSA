class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // prefix array.
        result[0] = 1;
        for(int i=1;i<nums.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(result));
        // [1, 2, 3, 4]
        // [1, 1, 2, 6]
        // [24 12 4, 1]
        // [24, 12, 8, 6]
        int suffix = 1;
        for(int i=nums.length-1;i>=0;i--){
            result[i] = result[i] * suffix;
            suffix = nums[i] * suffix;
        }
        return result;
    }
}