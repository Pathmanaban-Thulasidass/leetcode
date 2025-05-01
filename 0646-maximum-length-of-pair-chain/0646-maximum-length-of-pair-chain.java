class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs,(a,b) -> a[0] - b[0]);
        int dp[] = new int[n];
        int ans = 0;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(pairs[j][1] < pairs[i][0]){
                    max = Math.max(max,dp[j] + 1);
                }
            }
            dp[i] = Math.max(dp[i],max);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}