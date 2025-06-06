class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while(low <= high){
            int mid = (low + high) / 2;
            int totalHour = calcTotalHour(piles ,mid);
            if(totalHour <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i = 0 ; i < n; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    public static int calcTotalHour(int[] piles ,int mid){
        int total = 0;
        int n = piles.length;
        for(int i = 0; i < n ;i++){
            total += Math.ceil((double) piles[i] / (double) mid);
        }
        return total;
    }
}