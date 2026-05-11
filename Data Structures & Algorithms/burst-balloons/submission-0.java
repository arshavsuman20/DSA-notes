class Solution {
    public int maxCoins(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int x:arr) ans.add(x);
        ans.add(1);
        int[][] dp = new int[n+2][n+2];
        for(int row[]:dp) Arrays.fill(row, 0);
        for(int i=n ; i>=1 ; i--){
            for(int j=1 ; j<=n ; j++){
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int ind=i ; ind<=j ; ind++){
                    int coins = ans.get(i-1)*ans.get(ind)*ans.get(j+1) + 
                    dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, coins);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}
