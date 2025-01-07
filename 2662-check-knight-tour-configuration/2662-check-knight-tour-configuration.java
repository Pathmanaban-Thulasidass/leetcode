class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dx[] = {-2,-1,1,2,2,1,-1,-2};
        int dy[] = {1,2,2,1,-1,-2,-2,-1};
        int curI = 0;
        int curJ = 0;
        boolean flag = false;
        if(grid[0][0] != 0)
            return false;
        for(int j=1;j<m*n;j++){
            flag = false;
            for(int i=0;i<8;i++){
                if((curI + dx[i]) >= 0 && (curI + dx[i]) < m && (curJ + dy[i]) >= 0 && (curJ + dy[i]) < n){
                    if(grid[curI + dx[i]][curJ + dy[i]] == j){
                        curI = curI + dx[i];
                        curJ = curJ + dy[i];
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag)
                return false;
        } 
        return true;
    }
}