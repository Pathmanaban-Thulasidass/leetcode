class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        Integer[][] dp = new Integer[m][n];
        return helper(0, 0, m, n, dungeon, dp);
    }
    public int helper(int i,int j,int m,int n,int[][] dungeon,Integer[][] dp) {
        if(!isValidIndex(i, j, m, n)){
            return Integer.MAX_VALUE;
        }
        if(i == m - 1 && j == n - 1){
            return Math.max(1, 1 - dungeon[i][j]);
        }
        if(dp[i][j] != null)
            return dp[i][j];
        int down = helper(i + 1, j, m, n, dungeon, dp);
        int right = helper(i, j + 1, m, n, dungeon, dp);
        int minHealthNeededNext = Math.min(down, right);
        int minHealthCurrent = minHealthNeededNext - dungeon[i][j];
        return dp[i][j] = Math.max(1, minHealthCurrent);
    }
    public boolean isValidIndex(int i, int j, int m, int n) {
        return i >= 0 && i < m && 0 <= j && j < n;
    }
}
