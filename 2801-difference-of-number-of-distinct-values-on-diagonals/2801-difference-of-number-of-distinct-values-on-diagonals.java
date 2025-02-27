class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = Math.abs(findTopDiagonal(i-1,j-1,m,n,grid) - findDownDiagonal(i+1,j+1,m,n,grid));
            }
        }
        return ans;
    }
    public int findTopDiagonal(int i,int j,int m,int n,int[][] grid){
        Set<Integer> set = new HashSet<>();
        while(isValidIndex(i,j,m,n)){
            set.add(grid[i][j]);
            i--;
            j--;
        }
        return set.size();
    }
    public int findDownDiagonal(int i,int j,int m,int n,int[][] grid){
        Set<Integer> set = new HashSet<>();
        while(isValidIndex(i,j,m,n)){
            set.add(grid[i][j]);
            i++;
            j++;
        }
        return set.size();
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}