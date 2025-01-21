class Solution {
    public int[] countBits(int n) {
        // we are going to use the power 2 as the solution 
        // and we are going to use the significant bit for numbers like
        // 2 , 4 ,8 , 16, 32 etc...

        int[] dp = new int[n+1];
        int offset = 1;
        for(int i=1;i<=n;i++){
            if(offset * 2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
}