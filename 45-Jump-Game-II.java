class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,0,nums.length,nums,dp);
    }    
    public int helper(int curIndex,int curStep,int n,int[] nums,int dp[]){
        if(curIndex >= n - 1){
            return 0;
        }
        if(dp[curIndex] != -1)
            return dp[curIndex];
        int min = Integer.MAX_VALUE; 
        for(int i=curIndex+1;i<=curIndex + nums[curIndex];i++){
            int steps = helper(i,curStep + 1,n,nums,dp);
            if(steps != Integer.MAX_VALUE){
                min = Math.min(min,steps + 1);
            }
        }
        return dp[curIndex] = min;
    }
}