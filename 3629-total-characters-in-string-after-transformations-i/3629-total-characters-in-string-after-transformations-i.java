class Solution {
    final int MOD = (int)(1e9 + 7);
    public int lengthAfterTransformations(String s, int t) {
        int n = s.length();
        int ans = 0;
        Integer dp[][] = new Integer[26][t + 1];
        for(int i=0;i<n;i++){
            ans = (ans + helper(s.charAt(i) - 'a',t,dp)) % MOD;
        }
        return ans;
    }
    public int helper(int ch,int t,Integer dp[][]){
        if(dp[ch][t] != null)
            return dp[ch][t];
        int temp = ch + t;
        if(temp < 26)
            return dp[ch][t] = 1;
        int rem = 26 - ch;
        return dp[ch][t] = (helper(0,t - rem,dp) + helper(1,t - rem,dp)) % MOD;
    }
}