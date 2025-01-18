class Solution {

    public int firstMissingPositive(int[] nums) {
        // make all the -ve elements in the original input to 0
        // since they dont provide any value
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
        // To start indexing the input array to accomodate for accessing the Solution
        // set in O(1) time.
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (index >= 0 && index < nums.length) {
                // marking the index element to let us know that the element exists
                // while looping thru solution set
                if (nums[index] == 0) {
                    // case where the element we got to is 0 as we made in the
                    // in the first loop or came in as input.
                    nums[index] = (nums.length + 1) * -1;
                    // we made it to nums.length + 1 * -1 as we dont want to modify the input array.
                } else if (nums[index] > 0) {
                    nums[index] = nums[index] * -1;
                }
            }
        }

                System.out.println(Arrays.toString(nums));

        for (int i = 1; i < nums.length + 1; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
