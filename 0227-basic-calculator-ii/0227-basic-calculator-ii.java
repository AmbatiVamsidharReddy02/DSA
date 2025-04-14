public class Solution {
    public int calculate(String s) {
        int num = 0;
        char lastSign = '+';
        int lastNumber = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    result += lastNumber;
                    lastNumber = num;
                } else if (lastSign == '-') {
                    result += lastNumber;
                    lastNumber = -num;
                } else if (lastSign == '*') {
                    lastNumber = lastNumber * num;
                } else if (lastSign == '/') {
                    lastNumber = lastNumber / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
}