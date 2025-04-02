import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Begin by adding the first number as the first permutation
        result.add(new ArrayList<>());
        
        // Process each number in the input array
        for (int num : nums) {
            List<List<Integer>> newPermutations = new ArrayList<>();
            
            // Expand each existing permutation
            for (List<Integer> perm : result) {
                // Insert current number in every possible position
                for (int i = 0; i <= perm.size(); i++) {
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(i, num); // Insert current number
                    newPermutations.add(newPerm);
                }
            }
            
            // Update result with new permutations including the current number
            result = newPermutations;
        }
        
        return result;
    }
}