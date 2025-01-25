class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int previousValue = nums[i]-1;
            int count = 1;
            if(!set.contains(previousValue)){
                int nextVal = nums[i] + 1;
                while(set.contains(nextVal)){
                    count++;
                    nextVal++;
                }
            }
            if(maxCount < count){
                maxCount = count;
            }
            if(maxCount == set.size()){
                break;
            }
        }
        return maxCount;
    }
}