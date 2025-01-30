class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ones = 0;
        int zeroes = 0;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                zeroes++;
            }else{
                ones++;
            }

            int diff = ones - zeroes;
            if(!map.containsKey(diff)){
                map.put(diff, i);
            }

            if(diff==0){
                maxSize = ones+zeroes;
            }else{
                int index = map.get(diff);
                maxSize = Math.max(maxSize, i-index);
            }
        }
        return maxSize;
    }
}