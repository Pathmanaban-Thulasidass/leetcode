class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        return helper(n1 - 1,n2 - 1,word1,word2,new Integer[n1 + 1][n2 + 1]);
    }
    public int helper(int i,int j,String word1, String word2,Integer[][] dp){
        //If `word1` is exhausted, we need to insert all remaining characters of `word2`
        if(i < 0){
            return j + 1;
        }
        //If `word2` is exhausted, we need to delete all remaining characters in `word1`
        if(j < 0)
            return i + 1;
        if(dp[i][j] != null)
            return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            return helper(i-1,j-1,word1,word2,dp);
        }
        else{
            //Not Equal => Delete a character || Replace a character || Insert a character
            int deleteOp = 1 + helper(i - 1, j, word1, word2,dp);  // Delete a character from word1
            int replaceOp = 1 + helper(i - 1, j - 1, word1, word2,dp); // Replace a character
            int insertOp = 1 + helper(i, j - 1, word1, word2,dp); // Insert a character into word1

            return dp[i][j] = Math.min(deleteOp, Math.min(replaceOp, insertOp));
        }
    }
}