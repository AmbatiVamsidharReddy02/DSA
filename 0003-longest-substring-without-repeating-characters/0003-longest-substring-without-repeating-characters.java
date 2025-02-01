class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int maxSize = 0;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int currSize = map.size();
                maxSize = Math.max(maxSize, currSize);

                int jump = map.get(s.charAt(i));
                while (windowStart < (jump + 1)) {
                    map.remove(s.charAt(windowStart));
                    windowStart++;
                }
                windowStart = jump + 1;
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(maxSize, map.size());
    }
}
