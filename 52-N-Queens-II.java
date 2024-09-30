class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        findQueens(0,n,0,new boolean[n][n]);
        return ans;
    }
    public void findQueens(int rowI,int n,int queensCount,boolean [][] arr){
        if(rowI == n){
            if(queensCount == n){
                ans++;
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(isValidPosition(rowI,i,n,arr)){
                arr[rowI][i] = true;
                findQueens(rowI + 1,n,queensCount + 1,arr);
                arr[rowI][i] = false;
            }
        }
    }
    public boolean isValidPosition(int rowI,int colI,int n,boolean[][] arr){
        for(int i=0;i<n;i++){
            //Row
            if(arr[rowI][i])
                return false;
            //Col
            if(arr[i][colI])
                return false;
        }
        //Left-top
        int tempI = rowI;
        int tempJ = colI;
        while(tempI >= 0 && tempJ >= 0){
            if(arr[tempI][tempJ])
                return false;
            tempI--;
            tempJ--;
        }
        //Right-top
        tempI = rowI;
        tempJ = colI;
        while(tempI >=0 && tempJ < n){
            if(arr[tempI][tempJ])
                return false;
            tempI--;
            tempJ++;
        }
        //Left-bottom
        tempI = rowI;
        tempJ = colI;
        while(tempI < n && tempJ >= 0){
            if(arr[tempI][tempJ])
                return false;
            tempI++;
            tempJ--;
        }
        //Right-bottom
        tempI = rowI;
        tempJ = colI;
        while(tempI < n && tempJ < n){
            if(arr[tempI][tempJ])
                return false;
            tempI++;
            tempJ++;
        }
        return true;
    }
}