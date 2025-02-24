class Solution {
    int x[] = {-2,-2,-1,-1,1,1,2,2};
    int y[] = {-1,1,-2,2,-2,2,-1,1};
    final int MOD = (int)1e9 + 7;
    public int knightDialer(int n) {
        long count = 0;
        int dialer[][] = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        Long dp[][][] = new Long[4][3][n + 1];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(dialer[i][j] != -1){
                    count = (count + helper(i,j,n,1,dialer,dp)) % MOD;
                }
            }
        }
        return (int)count % MOD;
    }
    public long helper(int i,int j,int n,int curLen,int[][] dialer,Long dp[][][]){
        long count = 0;
        if(curLen == n)
            return 1;
        if(dp[i][j][curLen] != null)
            return dp[i][j][curLen];
        for(int k=0;k<8;k++){
            int ni = i + x[k];
            int nj = j + y[k];
            if(isValidIndex(ni,nj,4,3,dialer)){
                count = (count + helper(ni,nj,n,curLen + 1,dialer,dp)) % MOD;
            }
        }
        return dp[i][j][curLen] = count % MOD;
    }

    public boolean isValidIndex(int i,int j,int m,int n,int dialer[][]){
        return 0 <= i && i < m && 0 <= j && j < n && dialer[i][j] != -1;
    }
}