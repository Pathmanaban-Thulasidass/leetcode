class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0)
            return 0;     
        int ans = helper(n-1,amount,coins,new Integer[n][amount+1]);
        return ans >= (int)1e9 ? -1 : ans;
    }
    public int helper(int index,int target,int[] nums,Integer[][] dp){
        if(index == 0){
            if(target % nums[0] == 0){
                return target / nums[0];
            }
            else
                return (int)1e9;
        }
        if(dp[index][target] != null)
            return dp[index][target];
        int notPick = helper(index - 1,target,nums,dp);
        int pick = (int)1e9;
        if(target >= nums[index])
            pick = 1 + helper(index,target - nums[index],nums,dp);
        return dp[index][target] = Math.min(notPick,pick);
    }
}