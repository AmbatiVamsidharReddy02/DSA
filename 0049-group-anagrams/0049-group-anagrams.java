class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(sortedString, newList);
            }

        }
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            result.add(entry.getValue());
        }
        return result;
    }
}