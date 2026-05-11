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
                    //can buy: (1)skip buying : profit = dp[ind+1][0]
                    //(2) buy then pay price (-prices[ind]) and move to selling state
                    profit = Math.max((-prices[ind] + dp[ind+1][1]), (0 + dp[ind+1][0]));
                }
                else{
                    //can sell: (1)skip selling : profit = dp[ind+1][1]
                    //(2) sell then gain price and move to buying state
                    profit = Math.max((prices[ind] + dp[ind+1][0]), (0 + dp[ind+1][1]));
                }
                dp[ind][buy]=profit;
            }
        }

        return dp[0][0];
    }
}