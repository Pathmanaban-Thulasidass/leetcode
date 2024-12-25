class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                for(int r=i-k;r<=i+k;r++){
                    if(r < 0 || r >= m){
                        continue;
                    }
                    for(int c=j-k;c<=j+k;c++){
                        if(c < 0 || c >= n){
                            continue;
                        }
                        sum += mat[r][c];
                    }
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}