class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currArray, int[] nums, boolean[] used) {
        if (currArray.size() == nums.length) {
            result.add(new ArrayList<>(currArray));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                used[i] = true;
                currArray.add(nums[i]);
                backtrack(result, currArray, nums, used);

                used[i] = false;
                currArray.remove(currArray.size() - 1);
            }
        }

    }
}