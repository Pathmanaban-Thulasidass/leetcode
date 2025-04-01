class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        return helper(0,n,questions,new Long[n+1]);
    }
    public long helper(int index,int n,int[][] questions,Long[] dp){
        if(index >= n){
            return 0;
        }
        if(dp[index] != null)
            return dp[index];
        long notPick = helper(index+1,n,questions,dp);
        long pick = questions[index][0] + helper(index + questions[index][1] + 1,n,questions,dp);
        return dp[index] = Math.max(notPick,pick);
    }
}