class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // Base case: If we've reached the end of the string, add the current partition to result
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try to partition at each possible position
        for (int end = start; end < s.length(); end++) {
            // Check if the substring s[start:end+1] is a palindrome
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1)); // Make a choice
                backtrack(s, end + 1, current, result); // Explore
                current.remove(current.size() - 1); // Undo the choice
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        // Check if the string between left and right is a palindrome
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}