import java.util.Stack;

public class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }

                // Connect the child list to the current node
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null; // Don't forget to clear the child pointer
            }

            if (curr.next == null && !stack.isEmpty()) {
                // Pop from stack and attach it to the end of the current list
                curr.next = stack.pop();
                curr.next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}