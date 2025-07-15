class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for(int col = 0; col < n; col++){
            ans[col] = helper(0, col, m, n, grid);
        }
        return ans;
    }
    public int helper(int i, int j, int m, int n, int[][] grid) {
        if (i == m) {
            return j;
        }
        int dir = grid[i][j];
        int nextCol = j + dir;
        if (nextCol < 0 || nextCol >= n || grid[i][nextCol] != dir) {
            return -1;
        }
        return helper(i + 1, nextCol, m, n, grid);
    }
}
