class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        return helper(0,n,0,nums,new Long[n][2]);
    }
    public long helper(int index,int n,int state,int[] nums,Long dp[][]){
        if(index == n)
            return 0;
        if(dp[index][state] != null)
            return dp[index][state];
        long notPick = helper(index + 1,n,state,nums,dp);
        long pick = 0l;
        if(state == 0){ // even
            pick = nums[index] + helper(index + 1,n,1,nums,dp);
        }
        else{ // odd
            pick = -nums[index] + helper(index + 1,n,0,nums,dp);
        }
        return dp[index][state] = Math.max(notPick,pick);
    }
}