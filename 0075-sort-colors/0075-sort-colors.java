class Solution {
    public void sortColors(int[] nums) {
        // using dutch national flag algorithm

        // take three pointers low, mid, high
        // move mid as the traversal pointer till mid<=high
        // scenarios -
        // if mid == 0 then swap the mid, low element and increment both.
        // if mid == 1 then continue forward.
        // if the mid == 2 then swap the high, mid elements and then decrement only high
        // value.

        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}