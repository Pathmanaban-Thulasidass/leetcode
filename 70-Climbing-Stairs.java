class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n]; 
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }
    int helper(int curStep,int n,int dp[]){
        if(n < curStep)
            return 0;
        if(n == curStep){
            return 1;
        }
        if(dp[curStep] != -1){
            return dp[curStep];
        }
        return dp[curStep] = (helper(curStep + 1,n,dp) + helper(curStep + 2,n,dp));
    }
}