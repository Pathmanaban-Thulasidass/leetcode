class Solution {
    public int numEnclaves(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        boolean visited[][] = new boolean[row][col];
        //Left - Right - Top
        for(int i=0;i<col;i++){
            if(board[0][i] == 1){
                helperDFS(0,i,row,col,visited,board);
            }
        }
        //Left - Right - bottom
        for(int i=0;i<col;i++){
            if(board[row-1][i] == 1){
                helperDFS(row-1,i,row,col,visited,board);
            }
        }
        //Top - Bottom - First
        for(int i=0;i<row;i++){
            if(board[i][0] == 1){
                helperDFS(i,0,row,col,visited,board);
            }
        }
        //Top - Bottom - Last
        for(int i=0;i<row;i++){
            if(board[i][col-1] == 1){
                helperDFS(i,col-1,row,col,visited,board);
            }
        }
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                if(!visited[i][j] && board[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void helperDFS(int i,int j,int row,int col,boolean visited[][],int board[][]){
        if(i < 0 || i > row || j < 0 || j > col){
            return;
        }
        visited[i][j] = true;
        //Top
        if(i-1 >= 0 && !visited[i-1][j] && board[i-1][j] == 1){
            helperDFS(i-1,j,row,col,visited,board);
        }
        //Bottom
        if(i+1 < row && !visited[i+1][j] && board[i+1][j] == 1){
            helperDFS(i+1,j,row,col,visited,board);
        }
        //left
        if(j-1 >= 0 && !visited[i][j-1] && board[i][j-1] == 1){
            helperDFS(i,j-1,row,col,visited,board);
        }
        //Right
        if(j+1 < col && !visited[i][j+1] && board[i][j+1] == 1){
            helperDFS(i,j+1,row,col,visited,board);
        }
    }
}