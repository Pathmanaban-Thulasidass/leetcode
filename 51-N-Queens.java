class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        findQueens(0,n,0,new boolean[n][n],ans);
        return ans;
    }
    public void findQueens(int rowI,int n,int queensCount,boolean [][] arr,List<List<String>> ans){
        if(rowI == n){
            if(queensCount == n){
                convertor(n,arr,ans);
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(isValidPosition(rowI,i,n,arr)){
                arr[rowI][i] = true;
                findQueens(rowI + 1,n,queensCount + 1,arr,ans);
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
    public void convertor(int n,boolean[][] arr,List<List<String>> ans){
        boolean[][] tempArr = new boolean[n][n];
        StringBuffer sb = new StringBuffer();
        List<String> inner = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]){
                    sb.append(\Q\);
                }
                else{
                    sb.append(\.\);
                }
            }
            inner.add(sb.toString());
            sb.setLength(0);
        }
        ans.add(inner);
    }
}