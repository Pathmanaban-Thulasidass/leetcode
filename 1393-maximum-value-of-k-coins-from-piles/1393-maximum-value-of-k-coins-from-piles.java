class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        return helper(0,n,piles,k,new Integer[n][k + 1]);
    }
    public int helper(int index,int n,List<List<Integer>> piles,int k,Integer[][] dp){
        if(index == n || k <= 0){
            return 0;
        }
        if(dp[index][k] != null)
            return dp[index][k];
        int pick = 0;
        int notPick = helper(index + 1,n,piles,k,dp);
        int preSum = 0;
        for(int i=0;i<Math.min(k,piles.get(index).size());i++){
            preSum += piles.get(index).get(i);
            pick = Math.max(pick,preSum + helper(index + 1,n,piles,k - i - 1,dp));
        }
        return dp[index][k] = Math.max(pick,notPick);
    }
}