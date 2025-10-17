class Solution {
    public void sortColors(int[] nums) {
        /* we use three pointers
        low, mid, high
        we use low and high for the zeres and 2s tracking. 
        
        we use mid to travel thru the array.
        instances of mid are
        0 -> swap with nums[low] and increment low++; mid++;
        we know for sure that low will give us something like 1 cause we are sorting from low
        and we keep on sorting the array to the left of low and right of low will be 1s which are mids values 1.
        
        1 -> mid++;
        2 -> swap with nums[high] high--; // we wont do mid++ since we dont know what the
        high provides.
        * */

        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap with low
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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
