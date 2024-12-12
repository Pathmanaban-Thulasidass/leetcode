class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        Integer[][] dp = new Integer[n][n]; 
        for(int i=0;i<n;i++){
            min = Math.min(min,helper(0,i,n,matrix,dp));
        }
        return min;
    }
    public int helper(int i,int j,int n,int[][] matrix,Integer[][] dp){
        if(i >= n || j >= n || j < 0)
            return Integer.MAX_VALUE;
        if(i == n - 1){
            return matrix[i][j];
        } 
        if(dp[i][j] != null)
            return dp[i][j];
        return dp[i][j] = matrix[i][j] + Math.min(Math.min(helper(i+1,j-1,n,matrix,dp),helper(i+1,j,n,matrix,dp)),helper(i+1,j+1,n,matrix,dp));
    }
}