class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int[] maxLeft = new int[A.length];
        
        // Precompute maxLeft[i] which stores the maximum value of A[k] + k for all k <= i
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            maxVal = Math.max(maxVal, A[i] + i);
            maxLeft[i] = maxVal;
        }
        
        int maxScore = Integer.MIN_VALUE;
        // Compute max score using precomputed maxLeft values
        for (int j = 1; j < A.length; j++) {
            maxScore = Math.max(maxScore, maxLeft[j-1] + A[j] - j);
        }
        
        return maxScore;
    }
}
