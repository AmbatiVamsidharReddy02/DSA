class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int currIndex,  List<List<Integer>> result, List<Integer> currList){
        if(currIndex>= nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }

        // take the currIndex 
        currList.add(nums[currIndex]);
        backtrack(nums,currIndex+1, result, currList);

        // not take the currIndex
        currList.remove(currList.size()-1);
        backtrack(nums, currIndex+1, result, currList);
    }
}