class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int preSum[][] = new int[m + 1][n + 1];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                preSum[i + 1][j + 1] = grid[i][j]; 
            }
        } 
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] - preSum[i-1][j-1] + grid[i-1][j-1];
                if(preSum[i][j] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}