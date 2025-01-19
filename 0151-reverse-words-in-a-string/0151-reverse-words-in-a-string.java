class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            reversed.append(strs[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
}