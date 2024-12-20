class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        return helper(n1 - 1,n2 - 1,text1,text2,new Integer[n1 + 1][n2 + 1]);
    }
    public int helper(int index1,int index2,String text1, String text2,Integer[][] dp){
        if(index1 < 0 || index2 < 0)
            return 0;
        if(dp[index1][index2] != null)
            return dp[index1][index2];
        if(text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + helper(index1 - 1,index2 - 1,text1,text2,dp);
        //else both are not equal
        return dp[index1][index2] = Math.max(helper(index1 - 1,index2,text1,text2,dp),helper(index1,index2 - 1,text1,text2,dp));
    }
}