class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
        List<Integer> result = new ArrayList<>();
        while(left < right && top < bottom){
            for(int i=left; i<right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<bottom;i++){
                result.add(matrix[i][right-1]);
            }
            right--;

            if(!(left<right && top<bottom)){
                break;
            }

            for(int i=right-1;i>=left;i--){
                result.add(matrix[bottom-1][i]);
            }
            bottom--;

            for(int i=bottom-1;i>=top;i--){
                result.add(matrix[i][left]);

            }
            left++;
        }
        return result;
    }
}