class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            // Add current number to the set
            set.add(nums[i]);
            // If the size of the set exceeds k, remove the oldest element
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
