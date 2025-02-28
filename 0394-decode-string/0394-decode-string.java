class Solution {
    private int index = 0; 
    public String decodeString(String s) {

        StringBuilder result = new StringBuilder();

        while (index < s.length() && s.charAt(index) != ']') {
            char currentChar = s.charAt(index);
            if (Character.isDigit(currentChar)) {
                int k = 0;

                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index) - '0');
                    index++;
                }

                index++;
                String decodedSubstring = decodeString(s);

                while (k > 0) {
                    result.append(decodedSubstring);
                    k--;
                }

                // At this point the index would have moved past ']'
                index++; // Move past ']'

            } else {
                result.append(currentChar);
                index++;
            }
        }

        return result.toString();
    }
}