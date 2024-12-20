class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0)
                dp[0][i] = 1;
        }
        for(int index=1;index<n;index++){
            for(int target=1;target<=amount;target++){
                int notPick = dp[index - 1][target];
                int pick = 0;
                if(target >= coins[index])
                    pick = dp[index][target - coins[index]];
                dp[index][target] = pick + notPick;
            }
        }
        return dp[n - 1][amount];
    }
}