class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int rowSize = m + (k * 2);
        int colSize = n + (k * 2);
        int prefixSum[][] = new int[rowSize][colSize];
        int ans[][] = new int[m][n];
        for(int i=k;i<rowSize-k;i++){
            for(int j=k;j<colSize-k;j++){
                prefixSum[i][j] = mat[i-k][j-k];
            }
        }
        for(int i=k;i<rowSize;i++){
            int sum = 0;
            for(int j=k;j<colSize;j++){
                sum += prefixSum[i][j];
                prefixSum[i][j] = sum + prefixSum[i-1][j];
            }
        }   
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = prefixSum[i+ 2 * k][j+ 2 * k];
                if((i+ 2 * k) < rowSize && (j-1) >= 0){
                    ans[i][j] -= prefixSum[i+ 2 * k][j-1];
                }
                if((i - 1) >= 0 && (j+ 2 * k) < colSize){
                    ans[i][j] -= prefixSum[i-1][j+ 2 * k];
                }
                if((i-1) >= 0 && (j-1) >= 0){
                    ans[i][j] += prefixSum[i-1][j-1];
                }
            }
        }
        return ans;
    }
}