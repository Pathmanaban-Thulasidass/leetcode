class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                copy[i][j] = board[i][j];
            }
        } 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int noOfNeighbours = countNeighbours(i,j,m,n,copy);
                if(copy[i][j] == 0){
                    if(noOfNeighbours == 3)
                        board[i][j] = 1;
                }
                else{
                    //copy[i][j] == 1
                    if(noOfNeighbours < 2 || noOfNeighbours > 3){
                        board[i][j] = 0;
                    }
                }
            }
        }

    }
    public int countNeighbours(int i,int j,int m,int n,int nums[][]){
        //8 neighours co-oridinates
        int x[] = {1,1,0,-1,-1,-1,0,1};
        int y[] = {0,1,1,1,0,-1,-1,-1};
        int neighbours = 0;
        for(int a=0;a<8;a++){
            if((i + x[a]) >= 0 && (i + x[a]) < m && (j + y[a]) >= 0 && (j + y[a]) < n){
                if(nums[(i + x[a])][(j + y[a])] == 1)
                    neighbours++;
            }
        }
        return neighbours;
    }
}