class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    helperDFS(i,j,n,m,visited,grid);
                    island++;
                }
            }
        }
        return island;
    }
    public void helperDFS(int i,int j,int row,int col,boolean visited[][],char grid[][]){
        visited[i][j] = true;
        //Top
        if(i-1 >= 0 && grid[i-1][j] == '1' && !visited[i-1][j]){
            helperDFS(i-1,j,row,col,visited,grid);
        }
        //Bottom
        if(i+1 < row && grid[i+1][j] == '1' && !visited[i+1][j]){
            helperDFS(i+1,j,row,col,visited,grid);
        }
        //Left
        if(j-1 >= 0 && grid[i][j-1] == '1' && !visited[i][j-1]){
            helperDFS(i,j-1,row,col,visited,grid);
        }
        //Right
        if(j+1 < col && grid[i][j+1] == '1' && !visited[i][j+1]){
            helperDFS(i,j+1,row,col,visited,grid);
        }
    }
}