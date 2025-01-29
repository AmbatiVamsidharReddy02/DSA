class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // by default add prefixSum 0 and count as 1
        map.put(0, 1);
        int prefixSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            int prefixDiff = prefixSum - k;
            if (map.containsKey(prefixDiff)) {
                result += map.get(prefixDiff);
            }
            // add the prefix to hashmap with updated count
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}