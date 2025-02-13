class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        if (stack.isEmpty() && minStack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
        } else {
            int i = 0;
            while (!minStack.isEmpty() && val > minStack.peek()) {
                stack.push(minStack.pop());
                i++;
            }
            minStack.push(val);
            while (i > 0) {
                minStack.push(stack.pop());
                i--;
            }
            stack.push(val);
        }
    }

    public void pop() {
        // remove element from minStack()
        int i = 0;
        int val = stack.pop();
        while (val!=minStack.peek()) {
            stack.push(minStack.pop());
            i++;
        }
        minStack.pop();
        while(i>0){
            minStack.push(stack.pop());
            i--;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
