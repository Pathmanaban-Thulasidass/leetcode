class Solution {
    final int MOD = (int)1e9 + 7;
    public int countHomogenous(String s) {
        int n = s.length();
        long count = 1;
        long ans = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) != s.charAt(i+1)){
                ans = (ans + find(count)) % MOD;
                count = 1;
            }
            else{
                count++;
            }
        }
        ans += find(count);
        return (int)ans;
    }
    public long find(long n){
        return ((n * (n + 1)) / 2) % MOD;
    }
}