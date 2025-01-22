class Solution {

    public boolean isIsomorphic(String s, String t) {

        
        if (s.length() != t.length()) {
            return false;
        }
        // use two hashmaps to have the mappings between s->t and t->s
        Map<Character, Character> sToTmap = new HashMap<>();
        Map<Character, Character> tToSmap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s to t
            if (sToTmap.containsKey(charS)) {
                if (sToTmap.get(charS) != charT) return false;
            } else {
                sToTmap.put(charS, charT);
            }

            // Check mapping from t to s
            if (tToSmap.containsKey(charT)) {
                if (tToSmap.get(charT) != charS) return false;
            } else {
                tToSmap.put(charT, charS);
            }
        }
        return true;
    }
}
