class Solution {
    public int subarraysDivByK(int[] nums, int K) {
    Map<Integer, Integer> remainderCount = new HashMap<>();
    remainderCount.put(0, 1);  // Base case for subarrays directly divisible by K

    int sum = 0, count = 0;
    
    for (int num : nums) {
        sum += num;
        
        // Compute remainder of the current cumulative sum
        int remainder = sum % K;
        // Handle negative remainders by converting them into a positive range [0,K-1]
        if (remainder < 0) remainder += K;
        
        // If we have seen this remainder before, then there exist 'remainderCount.get(remainder)' subarrays ending at current index
        if (remainderCount.containsKey(remainder)) {
            count += remainderCount.get(remainder);
        }

        // Update the remainder count in the map
        remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
    }

    return count;
}
}