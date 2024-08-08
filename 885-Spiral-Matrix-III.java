class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int ans[][] = new int[rows * cols][2];
        int i = 1;
        int rowptr = rStart;
        int colptr = cStart;
        int addCount = 0;
        int temp;
        ans[0][0] = rowptr;
        ans[0][1] = colptr;
        // System.out.println("Right "+ Arrays.toString(ans[i-1]));
        while(i<rows*cols){
            //Right
            addCount++;
            // System.out.println("rowptr0  " + rowptr + "colptr  " + colptr + "addcount " + addCount);
            temp = colptr;
            colptr++;
            for(int k=colptr;k<=(temp + addCount);k++){
                if(rowptr < rows && rowptr >= 0 && colptr < cols && colptr >= 0){
                    ans[i][0] = rowptr;
                    ans[i++][1] = colptr;
                    // System.out.println("Right "+ Arrays.toString(ans[i-1]));
                }
                colptr++;
            }
            colptr--;
            // System.out.println("rowptr1  " + rowptr + "colptr  " + colptr + "addcount " + addCount);
            //Bottom
            temp = rowptr;
            rowptr++;
            for(int k=rowptr;k<=(temp + addCount);k++){
                if(rowptr < rows && rowptr >= 0 && colptr < cols && colptr >= 0){
                    ans[i][0] = rowptr; 
                    ans[i++][1] = colptr;
                    // System.out.println("Bottom "+ Arrays.toString(ans[i-1]));
                }
                rowptr++;
            }
            rowptr--;
            // System.out.println("rowptr2  " + rowptr + "colptr  " + colptr + "addcount " + addCount);
            addCount++;
            //Left
            temp = colptr;
            colptr--;
            for(int k=colptr;k>=(temp - addCount);k--){
                if(rowptr < rows && rowptr >= 0 && colptr < cols && colptr >= 0){
                    ans[i][0] = rowptr;
                    ans[i++][1] = colptr;
                    // System.out.println("Left "+ Arrays.toString(ans[i-1]));
                }
                colptr--;
            }
            colptr++;
            // System.out.println("rowptr3  " + rowptr + "colptr  " + colptr + "addcount " + addCount);
            //Top
            temp = rowptr;
            rowptr--;
            for(int k=rowptr;k>=(temp - addCount);k--){
                if(rowptr < rows && rowptr >= 0 && colptr < cols && colptr >= 0){
                    ans[i][0] = rowptr;
                    ans[i++][1] = colptr;
                    // System.out.println("Top "+ Arrays.toString(ans[i-1]));
                }
                rowptr--;
            }
            rowptr++;
            // System.out.println("rowptr4  " + rowptr + "colptr  " + colptr + "addcount " + addCount);
            // System.out.println("isBreaking   " + i + " " + rows*cols);
        }
        return ans;
    }
}