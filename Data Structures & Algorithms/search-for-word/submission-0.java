class Solution {
    int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows=board.length;
        cols=board[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(backtrack(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(char[][] board, String word, int r, int c, int i){
        if(i==word.length()) return true;
        if(r<0 || c<0 || r>=rows || c>=cols || board[r][c]!=word.charAt(i) || board[r][c]=='#')
            return false;
        board[r][c]='#';
        boolean res=backtrack(board, word, r+1,c,i+1) || backtrack(board,word,r-1,c,i+1)||
        backtrack(board,word,r,c+1,i+1) ||  backtrack(board,word,r,c-1,i+1);
        board[r][c]=word.charAt(i);
        return res;
    }
}
