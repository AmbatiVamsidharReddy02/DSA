class Solution {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int result = 0;

        while (start < end) {
            int area = (end-start) * Math.min(height[start], height[end]);
            result = Math.max(result, area);

            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }

        }
        return result;
    }
}
