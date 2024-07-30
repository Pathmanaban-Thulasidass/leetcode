class NumMatrix {

    int prefixSum[][];
    public NumMatrix(int[][] matrix) {
        prefixSum = new int[201][201];
        int sum = 0;
        for(int i=1;i<=matrix.length;i++){
            sum = 0;
            for(int j=1;j<=matrix[i-1].length;j++){
                sum += matrix[i-1][j-1];
                prefixSum[i][j] = sum + prefixSum[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1] - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */