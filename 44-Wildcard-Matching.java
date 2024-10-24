class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return helper(n-1,m-1,n,m,s,p,new Boolean[n+1][m+1]);
    }
    public boolean helper(int sIndex,int pIndex,int n,int m,String s, String p,Boolean[][] dp){
        if(sIndex < 0 && pIndex >= 0){
           for(int i=0;i<=pIndex;i++){
                if(p.charAt(i) != '*')
                    return false;
           }
           return true;
        }
        if(pIndex < 0 && sIndex >= 0){
            return false;
        }
        if(sIndex < 0 && pIndex < 0){
            return true;
        }
        if(dp[sIndex][pIndex] != null){
            return dp[sIndex][pIndex];
        }
        char pCh = p.charAt(pIndex);
        char sCh = s.charAt(sIndex);
        if(pCh == '*'){
            return dp[sIndex][pIndex] = helper(sIndex - 1,pIndex,n,m,s,p,dp) || helper(sIndex , pIndex - 1,n,m,s,p,dp);
        }
        else if(pCh == '?')
            return dp[sIndex][pIndex] = helper(sIndex - 1,pIndex - 1,n,m,s,p,dp);
        else{
            if(pCh == sCh){
                return dp[sIndex][pIndex] = helper(sIndex - 1,pIndex - 1,n,m,s,p,dp);
            }
            else
                return dp[sIndex][pIndex] = false;
        }
    }
}