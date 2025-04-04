class NumArray {
    private int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length+1];
        prefix[0] = 0;

        for(int i=1;i<=nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(prefix));
    }
    
    public int sumRange(int left, int right) {
        // System.out.println(Arrays.toString(prefix));
        if(left ==0){
            return prefix[right+1];
        }
        return prefix[right+1]-prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */