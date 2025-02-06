class Solution {

    public void setZeroes(int[][] a) {
        boolean rowZero = false, columnZero = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        columnZero = true;
                    }
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
        printArray(a);
        System.out.println(a.length);
        System.out.println(a[0].length);
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] == 0) {
                for (int j = 1; j < a[0].length; j++) {
                    a[i][j] = 0;
                }
            }
        }

        printArray(a);

        for (int i = 1; i < a[0].length; i++) {
            if (a[0][i] == 0) {
                for (int j = 1; j < a.length; j++) {
                    a[j][i] = 0;
                }
            }
        }

        printArray(a);

        if (columnZero) {
            for (int i = 0; i < a.length; i++) {
                a[i][0] = 0;
            }
        }
        printArray(a);
        if (rowZero) {
            for (int i = 1; i < a[0].length; i++) {
                a[0][i] = 0;
            }

            printArray(a);
        }
        printArray(a);
    }

    public void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
