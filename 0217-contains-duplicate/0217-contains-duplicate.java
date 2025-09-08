
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> inputData = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(inputData.contains(nums[i])){
                return true;
            }
            inputData.add(nums[i]);
        }
        return false;
    }
}