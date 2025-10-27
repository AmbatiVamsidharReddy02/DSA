class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pos1 = -1, pos2=-1;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                pos1= i;
                pos2 = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return new int[] { pos1, pos2 };
    }
}
