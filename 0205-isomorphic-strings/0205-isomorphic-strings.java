class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            
            if(sTot.containsKey(s.charAt(i)) && sTot.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }

             if(tTos.containsKey(t.charAt(i)) && tTos.get(t.charAt(i))!=s.charAt(i)){
                return false;
            }

            sTot.put(s.charAt(i), t.charAt(i));
            tTos.put(t.charAt(i), s.charAt(i));
    //        String mapAsString = sTot.keySet().stream()
    //   .map(key -> key + "=" + sTot.get(key))
    //   .collect(Collectors.joining(", ", "{", "}"));

    //   String mapAsString2 = tTos.keySet().stream()
    //   .map(key -> key + "=" + tTos.get(key))
    //   .collect(Collectors.joining(", ", "{", "}"));
    //   System.out.println(mapAsString);
    //   System.out.println(mapAsString2);
        }

        return true;
    }
}
