class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n == 0) return 0;
        int aheadNotBuy, aheadBuy, currBuy, currNotBuy;
        aheadNotBuy = aheadBuy = 0;
        for(int ind = n-1; ind>=0; ind--){
            //can buy: (1)skip buying : profit = dp[ind+1][0]
            //(2) buy then pay price (-prices[ind]) and move to selling state
            currBuy = Math.max((-prices[ind] + aheadNotBuy), (0 + aheadBuy));
                
            //can sell: (1)skip selling : profit = dp[ind+1][1]
            //(2) sell then gain price and move to buying state
            currNotBuy = Math.max((prices[ind] + aheadBuy), (0 + aheadNotBuy));
            
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}