class Solution {
    public Node connect(Node root) {
        Node dummyHead = new Node(0);
        Node current = root;

        while (current != null) {
            Node tail = dummyHead;  // Tail for the next level, starting from the dummy head.
            
            // Iterate over nodes in the current level
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }
                
                current = current.next;
            }

            // Move to the start of the next level
            current = dummyHead.next;
            dummyHead.next = null;  // Reset dummy head's next for the next iteration/level.
        }

        return root;
    }
}