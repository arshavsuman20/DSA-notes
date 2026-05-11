class Pair{
    int first; int second;
    Pair(int first, int second){this.first=first;   this.second=second;}
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int area=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]==1){
                    area = Math.max(area, bfs(row, col, grid));
                }
            }
        }
        return area;
    }
    int bfs(int r, int c, int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        grid[r][c]=0;
        q.add(new Pair(r,c));
        int ans=1;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.first;
            int col=p.second;
            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol));
                    grid[nrow][ncol]=0;
                    ans++;
                }
            }
        }
        return ans;
    }

}
