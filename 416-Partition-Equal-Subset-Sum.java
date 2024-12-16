class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        if(total % 2 != 0)
            return false;
        return helper(n-1,0,total,nums,new Boolean[n+1][total+1]);
    }
    public boolean helper(int index,int curSum,int total,int nums[], Boolean dp[][]) {
        if (index == 0) {
            curSum += nums[index];
            return total - curSum == curSum;
        }
        if(total - curSum == curSum){
            return true;
        }
        if (dp[index][curSum] != null)
            return dp[index][curSum];
        if(dp[index][curSum] = helper(index - 1, curSum + nums[index],total, nums, dp))
            return true;
        else
            dp[index][curSum] = false;
        if (dp[index][curSum] = helper(index - 1, curSum, total,nums, dp))
            return true;
        else
            dp[index][curSum] = false;
        return dp[index][curSum] = false;
    }
}