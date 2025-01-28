class NumArray {

    private int[] prefixSums;

    public NumArray(int[] nums) {
        // Initialize the prefix sums array
        prefixSums = new int[nums.length + 1];
        
        // Build the prefix sum array
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        // Use prefix sums to calculate the range sum in O(1) time
        return prefixSums[j + 1] - prefixSums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */