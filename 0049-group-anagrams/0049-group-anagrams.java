class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char key[] = strs[i].toCharArray();
            Arrays.sort(key);
            String keyString  = new String(key);
            System.out.println(keyString);
            
            if(map.containsKey(keyString)){
                map.get(keyString).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(keyString, list);
            }
            
        }
        return new ArrayList<>(map.values());
    }
}