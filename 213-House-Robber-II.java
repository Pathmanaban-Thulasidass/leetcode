class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int x = helper(n-2,0,nums,dp); // Consider 0 to n - 2 (not consider last elemnt)
        Arrays.fill(dp,-1);
        int y = helper(n-1,1,nums,dp); // Consider 1 to n - 1 (not consider first elemnt)
        return Math.max(x,y);
    }
    public int helper(int index,int firstIndex,int[] nums,int[] dp){
        if(index < firstIndex){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        return dp[index] = Math.max(nums[index] + helper(index - 2,firstIndex,nums,dp), helper(index - 1,firstIndex,nums,dp));
    }
}