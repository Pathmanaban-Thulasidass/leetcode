class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return helper(0,0,row,col,grid,new Integer[row][col]);
    }
    public int helper(int i,int j,int row,int col,int[][] grid,Integer[][] dp){
        if(i >= row ||j >= col){
            return Integer.MAX_VALUE;
        }
        if(i == row - 1 && j == col - 1){
            return grid[i][j];
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        return dp[i][j] = (grid[i][j] + Math.min(helper(i+1,j,row,col,grid,dp),helper(i,j+1,row,col,grid,dp)));
    }
}