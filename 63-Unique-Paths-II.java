class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer dp[][] = new Integer[m][n];
        return helper(0,0,m,n,obstacleGrid,dp);
    }
    public int helper(int i,int j,int m,int n,int[][] obstacleGrid,Integer dp[][]){
        if(i >= m || j >= n || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        if(dp[i][j] != null)
            return dp[i][j];
        return dp[i][j] = (helper(i+1,j,m,n,obstacleGrid,dp) + helper(i,j+1,m,n,obstacleGrid,dp));
    }
}