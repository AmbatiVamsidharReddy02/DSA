class Solution {

    public int[] productExceptSelf(int[] nums) {
        // use prefix and suffix arrays.

        int[] prefix = new int[nums.length];

        // for simplicity i have taken suffix but we could just use the
        // prefix array to calculate the result directly.
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i-1];
            suffix[nums.length - i-1] = suffix[nums.length - i] * nums[nums.length - i];
        }

        for(int i=0;i<prefix.length;i++){
            prefix[i] = prefix[i] * suffix[i];
        }
        return prefix;
    }
}
