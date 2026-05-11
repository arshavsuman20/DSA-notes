class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n+1][2];
        for(int[] rows: dp) Arrays.fill(rows, 0);
        dp[n][0] = dp[n][1] = 0;

        for(int ind = n-1; ind>=0; ind--){
            for(int buy=0; buy<=1 ; buy++){
                int profit = 0;
                if(buy==0){
                    profit = Math.max((-prices[ind] + dp[ind+1][1]), (0 + dp[ind+1][0]));
                }
                else{
                    profit = Math.max((prices[ind] + dp[ind+1][0]), (0 + dp[ind+1][1]));
                }
                dp[ind][buy]=profit;
            }
        }

        return dp[0][0];
    }
}