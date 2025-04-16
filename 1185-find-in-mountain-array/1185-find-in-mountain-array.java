class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak index using binary search
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peak = left;
        
        // Step 2: Binary search for target in the increasing part
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        
        // Step 3: Binary search for target in the decreasing part
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    
    private int binarySearch(MountainArray arr, int target, int left, int right, boolean isAsc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);
            if (midVal == target) {
                return mid;
            }
            if (isAsc) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midVal > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}