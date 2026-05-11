class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return f(n-1, amount, coins, dp);
    }
    int f(int ind, int T, int[] a, int[][] dp){
        if(ind == 0){
            return (T % a[0] == 0 ? 1 : 0);
        }
        if(dp[ind][T] != -1) return dp[ind][T];
        int notTake = f(ind-1, T, a, dp);
        int take=0;
        if(a[ind] <= T) take = f(ind, T-a[ind], a, dp);
        return dp[ind][T] = notTake + take;
    }
}