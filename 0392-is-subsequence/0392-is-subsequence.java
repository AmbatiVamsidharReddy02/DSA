class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if(s.length() == 0 || t.length() == 0 ){
            return true;
        }
        int spointer = 0;
        for (int i = 0; i < t.length(); i++) {
            if (spointer < s.length()) {
                if (s.charAt(spointer) == t.charAt(i)) {
                    spointer++;
                }
            } else {
                return true;
            }
        }
        return spointer >= s.length() ? true : false;
    }
}
