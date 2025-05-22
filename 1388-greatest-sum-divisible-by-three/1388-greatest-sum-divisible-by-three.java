class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][3];
        return helper(0, 0, nums, dp);
    }
    public int helper(int index, int mod, int[] nums, Integer[][] dp) {
        if(index == nums.length){
            return mod == 0 ? 0 : Integer.MIN_VALUE;
        }
        if(dp[index][mod] != null)
            return dp[index][mod];
        int notPick = helper(index + 1, mod, nums, dp);
        int pick = nums[index] + helper(index + 1, (mod + nums[index]) % 3, nums, dp);
        return dp[index][mod] = Math.max(pick, notPick);
    }
}
