class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.append(s.charAt(i));
            }
        }
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
}