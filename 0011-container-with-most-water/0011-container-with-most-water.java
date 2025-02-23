class Solution {

    public int maxArea(int[] h) {
        int maxArea=0;
        int start = 0;
        int end = h.length - 1;
        while (start < end) {
            // calculate the area;
            int area = (end - start ) * Math.min(h[start], h[end]);
            maxArea = Math.max(area, maxArea);
            if (h[start] < h[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
