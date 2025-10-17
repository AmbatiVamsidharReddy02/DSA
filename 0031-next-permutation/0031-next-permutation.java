class Solution {
    public void nextPermutation(int[] nums) {
        // find any dip
        // 2 1 5 4 3 0 0
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
             int left = 0, right = nums.length - 1;
            while (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        } else {
            // swap the index elment with the first highest number found from the end.
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[index] < nums[i]) {
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            // reverse the array from index + 1 to end of array to get the next permuation
            int left = index + 1, right = nums.length - 1;
            while (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

    }
}
