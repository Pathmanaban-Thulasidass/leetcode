class Solution {
    public int[][] generateMatrix(int size) {
        int [][] matrix = new int [size][size];
        List<Integer> ans = new ArrayList<>();
        int m = size;
        int n = size;
        int top = 0, bottom = m-1;
        int left = 0, right = n - 1;
        int val = 1;
        while(left <= right && top <= bottom){
            //right
            for(int i=left;i<=right;i++){
                matrix[top][i] = val++;
            }
            top++;
            //Bottom
            for(int i=top;i<=bottom;i++){
                matrix[i][right] = val++;
            }
            right--;
            //Left
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    matrix[bottom][i] = val++;
                }
                bottom--;
            }
            //Top
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left] = val++;
                }
                left++;
            }
        }
        return matrix;
    }
}