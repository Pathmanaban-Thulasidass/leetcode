class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i] - '0';
            if(matrix[0][i] == '1')
                max = 1;
        }
        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] - '0';
            if(matrix[i][0] == '1')
                max = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int min = 0;
                if(matrix[i][j] != '0'){
                    min = Math.min(dp[i-1][j],dp[i][j-1]);
                    min = Math.min(min,dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                    max = Math.max(max,min + 1);
                }
            }
        }
        return max * max;
    }
}