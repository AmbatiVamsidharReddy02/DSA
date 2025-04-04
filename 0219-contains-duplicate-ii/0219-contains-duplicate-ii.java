class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }   

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);

            if(set.size()>k){
                // remove the first value from the window to make it to size k
                set.remove(nums[i-k]);

            }


        }
        return false;
    }
}
