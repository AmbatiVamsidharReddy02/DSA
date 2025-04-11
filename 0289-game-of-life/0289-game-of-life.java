public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length, n = board[0].length;
        int[][] copyBoard = new int[m][n];
        
        // Copy the original board to a new board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        
        // Directions array to get the neighbors (8 directions)
        int[] neighbors = {-1, 0, 1};
        
        // Iterate through board cell by cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Check all 8 neighbors
                for (int x : neighbors) {
                    for (int y : neighbors) {
                        if (!(x == 0 && y == 0)) {
                            int r = i + x;
                            int c = j + y;

                            // Check the validity of the neighboring cell and if it was originally a live cell
                            if ((r >= 0 && r < m) && (c >= 0 && c < n) && copyBoard[r][c] == 1) {
                                liveNeighbors++;
                            }
                        }
                    }
                }
                
                // Apply the rules of the Game of Life to determine the next state of the cell
                if ((copyBoard[i][j] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0;
                }
                if ((copyBoard[i][j] == 0) && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}