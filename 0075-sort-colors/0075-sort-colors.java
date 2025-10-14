class Solution {
    public void sortColors(int[] nums) {
        // using extra space with o(n) time.
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroes++;
            if (nums[i] == 1)
                ones++;
            if (nums[i] == 2)
                twos++;
        }

        for (int i = 0; i < zeroes; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < ones; i++) {
            nums[i + zeroes] = 1;
        }
        for (int i = 0; i < twos; i++) {
            nums[i + zeroes + ones] = 2;
        }
    }
}