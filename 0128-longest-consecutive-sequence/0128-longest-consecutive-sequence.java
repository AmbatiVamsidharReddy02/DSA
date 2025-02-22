class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // now for each element check if it's next element is
        // present or not.
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int previousEle = nums[i]-1;
            int currEle = nums[i];
            if (!set.contains(previousEle)) {
                currEle++;
                while(set.contains(currEle)){
                    count++;
                    currEle++;
                }
            }
            maxCount = Math.max(maxCount, count+1);
             if(maxCount == set.size()){
                break;
            }
        }
        return maxCount;
    }
}
