class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        return helper(0,0,triangle,new Integer[m][n]);
    }
    public int helper(int i,int j,List<List<Integer>> triangle,Integer[][] dp){
        if(i >= triangle.size() || j >= triangle.get(i).size()){
            return 0;
        }
        if(i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != null)
            return dp[i][j];
        return dp[i][j] = triangle.get(i).get(j) + Math.min(helper(i+1,j,triangle,dp),helper(i+1,j+1,triangle,dp));
    }
    
}