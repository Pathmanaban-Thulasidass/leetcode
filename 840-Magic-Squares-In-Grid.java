class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows < 3 || cols < 3)
            return count;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 5 && isDiagonalValid(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isDiagonalValid(int [][] grid,int rowptr,int colptr){
        int sum = 0;
        try{
            if(
            (grid[rowptr-1][colptr-1] == 4 || grid[rowptr-1][colptr-1] == 8 || grid[rowptr-1][colptr-1] == 6 || grid[rowptr-1][colptr-1] == 2) 
            && 
            (grid[rowptr-1][colptr+1] == 4 || grid[rowptr-1][colptr+1] == 8 || grid[rowptr-1][colptr+1] == 6 || grid[rowptr-1][colptr+1] == 2) 
            && 
            (grid[rowptr+1][colptr+1] == 4 || grid[rowptr+1][colptr+1] == 8 || grid[rowptr+1][colptr+1] == 6 || grid[rowptr+1][colptr+1] == 2)
            &&
            (grid[rowptr+1][colptr-1] == 4 || grid[rowptr+1][colptr-1] == 8 || grid[rowptr+1][colptr-1] == 6 || grid[rowptr+1][colptr-1] == 2)
            &&
            (grid[rowptr-1][colptr] == 3 || grid[rowptr-1][colptr] == 1 || grid[rowptr-1][colptr] == 7 || grid[rowptr-1][colptr] == 9)
            &&
            (grid[rowptr][colptr+1] == 3 || grid[rowptr][colptr+1] == 1 || grid[rowptr][colptr+1] == 7 || grid[rowptr][colptr+1] == 9)
            &&
            (grid[rowptr+1][colptr] == 3 || grid[rowptr+1][colptr] == 1 || grid[rowptr+1][colptr] == 7 || grid[rowptr+1][colptr] == 9)
            &&
            (grid[rowptr][colptr-1] == 3 || grid[rowptr][colptr-1] == 1 || grid[rowptr][colptr-1] == 7 || grid[rowptr][colptr-1] == 9)   
        
        ) {
            sum += grid[rowptr-1][colptr-1];
            sum += grid[rowptr-1][colptr+1];
            sum += grid[rowptr+1][colptr+1];
            sum += grid[rowptr+1][colptr-1];
            sum += grid[rowptr-1][colptr];
            sum += grid[rowptr][colptr+1];
            sum += grid[rowptr+1][colptr];
            sum += grid[rowptr][colptr-1];
            sum += 5;
        }
        }catch(Exception e){
            return false;
        }
        int rowSum = 0;
        int colSum = 0;
        if(sum == 45){
            rowSum += grid[rowptr-1][colptr-1];
            rowSum += grid[rowptr-1][colptr];
            rowSum += grid[rowptr-1][colptr+1];

            colSum += grid[rowptr-1][colptr-1];
            colSum += grid[rowptr][colptr-1];
            colSum += grid[rowptr+1][colptr-1];
        }
        return rowSum == 15 && colSum == 15;
    }
}