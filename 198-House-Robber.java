class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,nums.length,nums,dp);
    }
    public int helper(int index,int n,int[] nums,int[] dp){
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        return dp[index] = Math.max(nums[index] + helper(index - 2,n,nums,dp), helper(index - 1,n,nums,dp));
    }
}