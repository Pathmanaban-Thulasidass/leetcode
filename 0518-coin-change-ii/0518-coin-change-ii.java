class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return helper(n-1,amount,coins,new Integer[n][amount + 1]);
    }
    public int helper(int index,int target,int nums[],Integer[][] dp){
        if(index == 0){
            if(target % nums[0] == 0 || target == 0)
                return 1;
            return 0;
        }
        if(dp[index][target] != null)
            return dp[index][target];
        int notPick = helper(index - 1,target,nums,dp);
        int pick = 0;
        if(target >= nums[index])
            pick = helper(index,target - nums[index],nums,dp);
        return dp[index][target] = pick + notPick;
    }
}