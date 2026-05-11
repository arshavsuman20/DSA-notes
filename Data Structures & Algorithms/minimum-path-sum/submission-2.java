class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        int[] prev=new int[m]; Arrays.fill(prev, 0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            int[] curr=new int[m]; Arrays.fill(curr, 0);
            for(int j=0;j<m;j++){
                if(i==0 && j==0) curr[j] = grid[i][j];
                else{
                    int up=grid[i][j];
                    //req prev row's j column
                    if(i>0) up+=prev[j];
                    else up+=(int)(1e9);
                    
                    int left=grid[i][j];
                    //curr row's j-1 column
                    if(j>0) left+=curr[j-1];
                    else left+=(int)(1e9);

                    curr[j]=Math.min(up, left);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }
}