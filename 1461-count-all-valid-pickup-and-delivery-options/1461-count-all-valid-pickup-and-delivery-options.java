class Solution {
    final int MOD = (int)1e9 + 7;
    public int countOrders(int n) {
        return (int)helper(n);
    }
    public long helper(int n){
        if(n == 1)
            return 1;
        return  (n * ((((n * 2) - 1) * (helper(n - 1) % MOD)) % MOD)) % MOD;
    }
}