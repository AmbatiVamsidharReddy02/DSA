class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dataMap = new int[26];
        for(int i=0;i<s.length();i++){
            dataMap[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++){
            dataMap[t.charAt(i)-'a']--;
        }

        for(int i=0;i<dataMap.length;i++){
            if(dataMap[i]>0 || dataMap[i]<0){
                return false;
            }
        }
        return true;
    }
}