
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dataMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            dataMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (dataMap.containsKey(diff) && dataMap.get(diff) != i) {
                return new int[] { i, dataMap.get(diff) };
            }
        }
        return new int[] {-1, -1};
    }
}