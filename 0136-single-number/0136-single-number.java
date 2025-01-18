class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // XOR operation
        // X ^ 0 = X
        // X ^ X = 0

        // if we xor all the numbers in the array we get the element
        // since duplicates cancel out each other.
        for(int num: nums){
            result = result ^ num;
        }
        return result;
    }
}