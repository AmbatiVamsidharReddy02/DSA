class Solution {
    public void rotate(int[][] matrix) {
        // rotate the array.
        // first vertically reverse the array meaning swap elements in each columns top
        // becomes bottom, second top becomes second bottom and so on..

        int len = matrix.length;
        // lets start with row 0 and iterate till len/2 (only half)

        int row = 0;
        while (row < len / 2) {
            // now for each row traverse columns and swap them one by one of that row.
            for (int i = 0; i < len; i++) {
                int temp = matrix[row][i];
                matrix[row][i] = matrix[len - row - 1][i];
                matrix[len - row - 1][i] = temp;
            }
            row++;
        }

        // vertical swapping is done.
        // now for transpose where we swap rows to columns and columns to rows
        // (basically swapping all the opposite elements wrt diagonal of a matrix)

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}