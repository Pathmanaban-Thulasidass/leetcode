class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        return helper(n1-1,n2-1,s,t,new Integer[n1 + 1][n2 + 1]);
    }
    public int helper(int i,int j,String s,String t,Integer[][] dp){
        if(j < 0)
            return 1;
        if(i < 0)
            return  0;
        if(dp[i][j] != null)
            return  dp[i][j];
        int equal = 0;
        int notEqual = 0;
        if(s.charAt(i) == t.charAt(j)){
            equal =  helper(i-1,j-1,s,t,dp) + helper(i-1,j,s,t,dp); 
        }
        else{
            notEqual = helper(i-1,j,s,t,dp);
        }
        return dp[i][j] = equal + notEqual;
    }
    
}