// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;

//     public Node(boolean val, boolean isLeaf) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//     }

//     public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = topLeft;
//         this.topRight = topRight;
//         this.bottomLeft = bottomLeft;
//         this.bottomRight = bottomRight;
//     }
// }

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int row, int col, int size) {
        // Check if the entire grid section is uniform
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int mid = size / 2;
        // Recursively divide into four quadrants
        Node topLeft = construct(grid, row, col, mid);
        Node topRight = construct(grid, row, col + mid, mid);
        Node bottomLeft = construct(grid, row + mid, col, mid);
        Node bottomRight = construct(grid, row + mid, col + mid, mid);

        // Create a parent node for the 4 quadrants
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}