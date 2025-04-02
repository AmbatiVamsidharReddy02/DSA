class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // Precompute whether s[i, j] is a palindrome
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && (length <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            // Use precomputed DP table to check for palindrome
            if (dp[start][end]) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result, dp);
                current.remove(current.size() - 1);
            }
        }
    }
}