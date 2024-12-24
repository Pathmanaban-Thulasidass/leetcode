class Solution {
    public int minimumDeleteSum(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int totalAscii = 0;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1; i++) {
            totalAscii += word1.charAt(i);
        }
        for (int i = 0; i < n2; i++) {
            totalAscii += word2.charAt(i);
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + word1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcsAscii = dp[n1][n2];
        return totalAscii - 2 * lcsAscii;
    }
}
