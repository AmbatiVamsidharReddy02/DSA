import java.util.Random;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void quickSelect(int[][] points, int left, int right, int K) {
        if (left >= right) return;
        
        // Random pivot selection for improved average performance
        Random rand = new Random();
        int pivotIdx = left + rand.nextInt(right - left);
        
        // Partition the array around the pivot
        int pivotFinalIdx = partition(points, left, right, pivotIdx);
        
        // Recurse into the left or right half based on pivot position
        if (K < pivotFinalIdx) {
            quickSelect(points, left, pivotFinalIdx - 1, K);
        } else if (K > pivotFinalIdx) {
            quickSelect(points, pivotFinalIdx + 1, right, K);
        }
    }
    
    private int partition(int[][] points, int left, int right, int pivotIdx) {
        int pivotDist = distance(points[pivotIdx]);
        swap(points, pivotIdx, right);
        
        int storeIdx = left;
        for (int i = left; i < right; i++) {
            if (distance(points[i]) < pivotDist) {
                swap(points, storeIdx, i);
                storeIdx++;
            }
        }
        
        swap(points, storeIdx, right);
        return storeIdx;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}