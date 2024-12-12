class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer dp[] = new Integer[n + 1];
        return Math.min(helper(0,n,cost,dp),helper(1,n,cost,dp));
    }
    public int helper(int curIndex,int n,int cost[],Integer dp[]){
        if(curIndex >= n){
            return 0;
        }
        if(dp[curIndex] != null)
            return dp[curIndex];
        return dp[curIndex] = cost[curIndex] + Math.min(helper(curIndex + 1,n,cost,dp),helper(curIndex + 2,n,cost,dp));
    }
}