class Solution {
    public int[] singleNumber(int[] nums) {
        int arrayXor = 0;

        for(int i=0;i<nums.length;i++){
            arrayXor ^= nums[i];
        }
        int diff = arrayXor & (-arrayXor);
        int res1 = 0;
        int res2 = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & diff) == 0){
                res1 ^= nums[i];
            }else{
                res2 ^= nums[i];
            }
        }
        return new int[]{res1, res2};
    }
}