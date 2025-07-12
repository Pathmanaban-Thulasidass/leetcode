class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return helper(0,n,0,0,k,prices,new Integer[n][2][k]);
    }
    public int helper(int index,int n,int state,int tranc,int k,int prices[],Integer dp[][][]){
        if(index == n || tranc == k)
            return 0;
        if(dp[index][state][tranc] != null)
            return dp[index][state][tranc];
        if(state == 0){ // buy
            int notPick = helper(index + 1,n,state,tranc,k,prices,dp);
            int pick = -prices[index] + helper(index + 1,n,1,tranc,k,prices,dp);
            return dp[index][state][tranc] = Math.max(notPick,pick);
        }
        else{ // sell
            int notPick = helper(index + 1,n,state,tranc,k,prices,dp);
            int pick = prices[index] + helper(index + 1,n,0,tranc + 1,k,prices,dp);
            return dp[index][state][tranc] = Math.max(notPick,pick);
        }
    }
}