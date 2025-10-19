class Solution {
   public List<Integer> majorityElement(int[] nums) {
        // hasmap approach
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int occurance = nums.length/3;
        List<Integer> res = map.entrySet().stream().filter(x-> x.getValue()>occurance).map(x-> x.getKey()).collect(Collectors.toList());
        return res;
    }
}