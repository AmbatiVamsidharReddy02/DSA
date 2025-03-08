class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length-1; 

        while(left<=right){
            int mid = left + (right-left)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[0].length-1]){
                // do binary search on this row.
                int rowLeft = 0, rowRight = matrix[0].length-1;
                while(rowLeft<=rowRight){
                    int rowMid = rowLeft + (rowRight-rowLeft)/2;
                    if(target == matrix[mid][rowMid]){
                        return true;
                    }else if(target>matrix[mid][rowMid]){
                        rowLeft = rowMid + 1;
                    }else{
                        rowRight = rowMid -1;
                    }
                }
                return false;
            }else if(target>matrix[mid][matrix[0].length-1]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}