class Solution {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}
