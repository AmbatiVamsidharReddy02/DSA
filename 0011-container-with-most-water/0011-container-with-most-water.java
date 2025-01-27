class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length-1;
        int maxArea = 0;
        while(leftPointer< rightPointer && rightPointer != height.length){
            int width = rightPointer - leftPointer;
            int heightv = Math.min(height[rightPointer], height[leftPointer]);
            maxArea = Math.max(maxArea, width * heightv);

            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        return maxArea;
    }
}