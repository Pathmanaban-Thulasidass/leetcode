class Solution {
    final int MOD = (int)1e9 + 7;
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<List<Integer>> hatToPeople = new ArrayList<>();
        for (int i = 0; i <= 40; i++) hatToPeople.add(new ArrayList<>());
        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                hatToPeople.get(hat).add(person);
            }
        }
        return helper(1, 0, hatToPeople, n, new Integer[41][1 << n]);
    }

    private int helper(int hat, int mask, List<List<Integer>> hatToPeople, int n, Integer[][] dp) {
        if (mask == (1 << n) - 1) return 1; 
        if (hat > 40) return 0;  
        if (dp[hat][mask] != null) return dp[hat][mask];
        int ways = helper(hat + 1, mask, hatToPeople, n, dp);
        for (int person : hatToPeople.get(hat)) {
            if ((mask & (1 << person)) == 0) {
                ways = (ways + helper(hat + 1, mask | (1 << person), hatToPeople, n, dp)) % MOD;
            }
        }
        return dp[hat][mask] = ways;
    }
}
