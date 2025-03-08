class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if((open == max)  && (close== max)){
            result.add(current.toString());
            return;
        }
        if(open < max){
            current.append("(");
            backtrack(result, current, open+1, close, max);
            current.deleteCharAt(current.length()-1);
        }

        if(open>close){
            current.append(")");
            backtrack(result, current, open, close+1, max);
            current.deleteCharAt(current.length()-1);
        }
    }
}