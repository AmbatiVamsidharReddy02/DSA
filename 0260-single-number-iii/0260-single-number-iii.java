class Solution {
    public int[] singleNumber(int[] nums) {
        // do the xor for all the numbers to get the xor for the 
        // unique elements in the array.
        int xor = 0;
        for(int num:nums){
            xor ^= num;
        }

        // now to segregate the numbers which are different.
        // we are going to use the set bit from the xor operation before
        // so, we run thru all the elements in the array, to see 
        // if the set bit is 0 or 1 in that number then we xor them. 

        // why this works. well the xor operation from before gives the set
        // bit only when there is a 0 or 1 in both the unique numbers.
        // so we use this,

        int rightSetBit = xor & -xor;
        int result[] = new int[2];
        for(int num:nums){
            if((rightSetBit & num) == 0){
                result[0] ^= num;
            }else{
                result[1] ^= num;
            }
        }
        return result;
    }
}