class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int n = nums.length;
        Integer dp[] = new Integer[25001];
        for(int i=0;i<n;i++){
            max = Math.max(max,helper(i,n,nums,dp));
        }
        return max;
    }    
    public int helper(int index,int n,int[] nums,Integer[] dp){
        if(dp[index] != null)
            return dp[index];
        int max = 1;
        for(int i=index + 1;i<n;i++){
            if(nums[index] < nums[i]){
                max = Math.max(max,helper(i,n,nums,dp) + 1);
            }
        }
        return dp[index] = max;
    }
}