class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if ((s.length() == 0 || p.length()==0) || p.length() > s.length()) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        int[] alphabeticArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            alphabeticArray[p.charAt(i) - 'a']++;
        }
        String key = Arrays.toString(alphabeticArray);
        Arrays.fill(alphabeticArray, 0);
        // construct the window for p size first
        for (int i = 0; i < p.length(); i++) {
            alphabeticArray[s.charAt(i) - 'a']++;
        }
        if (Arrays.toString(alphabeticArray).equals(key)) {
            result.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            // add a element and remove a element and change the count and see the result
            // key
            alphabeticArray[s.charAt(i - 1) - 'a']--;
            alphabeticArray[s.charAt(i + p.length() - 1) - 'a']++;
            Arrays.toString(alphabeticArray);
            if (Arrays.toString(alphabeticArray).equals(key)) {
                result.add(i);
            }
        }
        return result;
    }
}