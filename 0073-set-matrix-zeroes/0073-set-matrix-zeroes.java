class Solution {
    public void setZeroes(int[][] matrix) {
        // first check the first row and first column to see if there are any zeroes in
        // them to prevent overriding.

        boolean rowZero = false;
        boolean columnZero = false;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                columnZero = true;
                break;
            }
        }

        for (int i = 0; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        // loop thru the inner array and if we find the zero element mark the first row
        // and first column to 0.
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        // now paint the matrix with 0s based on row zero and column zero.

        for (int i = 1; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < columnLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int i = 1; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(rowZero + " "+ columnZero);
        if(rowZero){
            for(int i=0;i<columnLength;i++){
                matrix[0][i] = 0;
            }
        }
        if(columnZero){
            for(int i=0;i<rowLength;i++){
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }

}