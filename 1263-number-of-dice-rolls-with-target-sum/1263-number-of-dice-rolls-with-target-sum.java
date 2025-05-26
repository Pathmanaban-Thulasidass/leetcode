class Solution {
    final int MOD = (int)(1e9 + 7);
    public int numRollsToTarget(int n, int k, int target) {
        Integer dp[][] = new Integer[n + 2][target + 1];
        return helper(1,n,k,0,target,dp);
    }
    public int helper(int diceNo,int totalDice,int k,int curSum,int target,Integer dp[][]){
        if(diceNo > totalDice){
            if(curSum == target)
                return dp[diceNo][curSum] = 1;
            return dp[diceNo][curSum] = 0;
        }
        if(dp[diceNo][curSum] != null)
            return dp[diceNo][curSum];
        int temp = 0;
        for(int i=1;i<=k;i++){
            if((curSum + i) <= target){
                temp = (temp + helper(diceNo + 1,totalDice,k,curSum + i,target,dp)) % MOD;
            }
        }
        return dp[diceNo][curSum] = temp;
    }
}