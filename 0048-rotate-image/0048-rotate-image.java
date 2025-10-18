class Solution {
    public void rotate(int[][] matrix) {
        // to rotate a matrix. 
        // 1. reverse numbers every column one by one.
        for( int i=0;i<matrix[0].length;i++) {
            int low = 0, high = matrix.length-1;
            while (low <= high) {
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;
                low++;high--;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        // 2. transpose the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j< matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}