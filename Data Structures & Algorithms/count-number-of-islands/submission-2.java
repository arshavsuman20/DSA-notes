//stores cell position (row, col)
class Pair{
    int first; int second;
    public Pair(int first, int second){
        this.first=first;   this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0; //total islands
        for(int row=0; row<n;row++){
            for(int col=0;col<m;col++){
                //start bfs when island found
                if(vis[row][col]==0 && grid[row][col]=='1'){ //cell is land and not visited ==new island
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
    void bfs(int r, int c, int[][] vis, char[][] grid){
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1, 0, 1, 0}; //U R D L
        int[] dcol = {0, 1, 0, -1}; //U R D L
        while(!q.isEmpty()){
            //get current cell
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                //inside grid, is land, not visited
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;   //correct cell marked
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}