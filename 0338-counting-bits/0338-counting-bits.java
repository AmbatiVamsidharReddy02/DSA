class Solution {
    public int[] countBits(int n) {
        if(n==0){
            return new int[n+1];
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int offset = 1;
        for(int i=2;i<=n;i++){
            if(offset * 2 == i){
                offset = i;
            }
            dp[i] = dp[i-offset] + 1;
        }
        return dp;
    }
}