class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n == 0) return 0;
        int[] ahead=new int[2]; Arrays.fill(ahead, 0);
        int[] curr=new int[2]; Arrays.fill(curr, 0);
        ahead[0] = ahead[1] = 0;

        for(int ind = n-1; ind>=0; ind--){
            for(int buy=0; buy<=1 ; buy++){
                int profit = 0;
                if(buy==0){
                    //can buy: (1)skip buying : profit = dp[ind+1][0]
                    //(2) buy then pay price (-prices[ind]) and move to selling state
                    profit = Math.max((-prices[ind] + ahead[1]), (0 + ahead[0]));
                }
                else{
                    //can sell: (1)skip selling : profit = dp[ind+1][1]
                    //(2) sell then gain price and move to buying state
                    profit = Math.max((prices[ind] + ahead[0]), (0 + ahead[1]));
                }
                curr[buy]=profit;
            }
            ahead=curr;
        }

        return ahead[0];
    }
}