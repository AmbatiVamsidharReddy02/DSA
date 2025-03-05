class Solution {
    public int findPeakElement(int[] a) {
        if (a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return 0;
        }
        if (a[0] > a[1]) {
            return 0;
        }
        if (a[a.length - 1] > a[a.length - 2]) {
            return a.length - 1;
        }

        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid != 0 && mid != a.length - 1) {
                if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
                    return mid;
                }else if(a[mid]<a[mid+1]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            } else {
                if (mid == 0 && mid + 1 != a.length) {
                    if(a[mid] > a[mid + 1]){
                        return mid;
                } else {
                    left = mid+1;
                }
                }else{
                    if( a[mid] > a[mid - 1]){
                        return mid;
                } else {
                    right = mid-1;
                }
                }
            }
        
        }
        return -1;
}
}