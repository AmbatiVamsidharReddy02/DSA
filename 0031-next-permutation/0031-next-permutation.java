class Solution {
    public static void reverseRange(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public void nextPermutation(int[] nums) {
        // 2 1 5 4 3 0 0

        int index = -1;
        int n = nums.length;
        // find the dip
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            // reverse the array and return it as result;
            reverseRange(nums, 0, n-1);
        } else {
            // found the dip
            // check for the greatest minimum from the prefix.
            int currEle = nums[index];
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > currEle) {
                    // swap them
                    currEle = nums[i];
                    nums[i] = nums[index];
                    nums[index] = currEle;
                    break;
                }
            }

            // now reverse the entire prefix from index+1 to end of array, to get the next
            // permutation.
            reverseRange(nums, index + 1, n-1);
        }
    }
}