class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int t;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        int first = 0;
        int last = n-1;
        for(int i=0;i<n;i++){
            first = 0;
            last = n-1;
            while(first < last){
                t = matrix[i][first];
                matrix[i][first++] = matrix[i][last];
                matrix[i][last--] = t;
            }
        }
        
    }
}