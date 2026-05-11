class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans=new ArrayList<>();
        nQueens(board, 0, n, ans);
        return ans;
    }
    void nQueens(char[][] board, int row, int n, List<List<String>> ans){
        if(row==n){
            List<String> c=new ArrayList<>();
            for(int i=0;i<n;i++){
                c.add(new String(board[i]));
            }
            ans.add(c);
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(board, row, j, n)){
                board[row][j]='Q'; //place queen
                nQueens(board, row+1, n, ans); 
                board[row][j] = '.'; //bactracking
            }
        }
    }
    boolean isSafe(char[][] board, int row, int col, int n){
        //vertical
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        //left diagonal
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q') return false;
        }
        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n;i--, j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}