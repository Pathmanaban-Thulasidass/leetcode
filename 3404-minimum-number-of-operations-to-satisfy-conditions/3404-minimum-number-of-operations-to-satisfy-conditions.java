class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(m + "  " + n);
        int freq[][] = new int[n][10];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                freq[j][grid[i][j]]++;
            }
        }
        return helper(n-1,10,m,freq,new Integer[n][11]);
    }
    public int helper(int index,int last,int n,int freq[][],Integer dp[][]){
        if(index == -1){
            return 0;
        }
        if(dp[index][last] != null)
            return dp[index][last];
        int min = (int)(1e8);
        for(int i=0;i<10;i++){
            if(i != last){
                min = Math.min(min, (n - freq[index][i]) + helper(index - 1,i,n,freq,dp));
            }
        }
        return dp[index][last] = min;
    }
}