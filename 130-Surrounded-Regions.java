class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean visited[][] = new boolean[row][col];
        //Left - Right - Top
        for(int i=0;i<col;i++){
            if(board[0][i] == 'O'){
                helperDFS(0,i,row,col,visited,board);
            }
        }
        //Left - Right - bottom
        for(int i=0;i<col;i++){
            if(board[row-1][i] == 'O'){
                helperDFS(row-1,i,row,col,visited,board);
            }
        }
        //Top - Bottom - First
        for(int i=0;i<row;i++){
            if(board[i][0] == 'O'){
                helperDFS(i,0,row,col,visited,board);
            }
        }
        //Top - Bottom - Last
        for(int i=0;i<row;i++){
            if(board[i][col-1] == 'O'){
                helperDFS(i,col-1,row,col,visited,board);
            }
        }
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void helperDFS(int i,int j,int row,int col,boolean visited[][],char[][] board){
        if(i < 0 || i > row || j < 0 || j > col){
            return;
        }
        visited[i][j] = true;
        //Top
        if(i-1 >= 0 && !visited[i-1][j] && board[i-1][j] == 'O'){
            helperDFS(i-1,j,row,col,visited,board);
        }
        //Bottom
        if(i+1 < row && !visited[i+1][j] && board[i+1][j] == 'O'){
            helperDFS(i+1,j,row,col,visited,board);
        }
        //left
        if(j-1 >= 0 && !visited[i][j-1] && board[i][j-1] == 'O'){
            helperDFS(i,j-1,row,col,visited,board);
        }
        //Right
        if(j+1 < col && !visited[i][j+1] && board[i][j+1] == 'O'){
            helperDFS(i,j+1,row,col,visited,board);
        }
    }
}