class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                if(stack.empty()){
                    return false;
                }
                char topCharacter = stack.peek();

                if(map.get(topCharacter) == c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
