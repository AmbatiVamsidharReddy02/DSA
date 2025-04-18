import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);  // Sorting helps in pruning
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Important pruning: if current candidate exceeds the target, further candidates will also exceed
            if (candidates[i] > target) break;
            
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, results);
            current.remove(current.size() - 1);
        }
    }
}