class Solution {
    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = n / 2;
        long oddCount = n - evenCount;

        long result = (sqrt(5, oddCount, 1) * sqrt(4, evenCount, 1)) % MOD;
        return (int) result;
    }

    public long sqrt(long x, long n, long ans) {
        if (n == 0) {
            return ans;
        }
        if (n % 2 == 0) {
            return sqrt((x * x) % MOD, n / 2, ans);
        } else {
            return sqrt((x * x) % MOD, n / 2, (ans * x) % MOD);
        }
    }
}
