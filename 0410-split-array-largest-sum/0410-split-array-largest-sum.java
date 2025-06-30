class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        return helper(0, n, k, nums, new Integer[n + 1][k + 1]);
    }
    public int helper(int index, int n, int k, int[] nums, Integer[][] dp){
        if(index == n){
            return (k == 0) ? 0 : Integer.MAX_VALUE;
        }
        if(k == 0)
            return Integer.MAX_VALUE;
        if(dp[index][k] != null){
            return dp[index][k];
        }
        int min = Integer.MAX_VALUE;
        int preSum = 0;
        for(int i = index; i < n; i++){
            preSum += nums[i];
            int next = helper(i + 1, n, k - 1, nums, dp);
            if(next != Integer.MAX_VALUE){
                min = Math.min(min, Math.max(preSum, next));
            }
        }
        return dp[index][k] = min;
    }
}
