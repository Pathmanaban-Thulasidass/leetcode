class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        boolean isNotPrime[] = new boolean[n+1];
        for(int i=2;i*i <= n;i++){
            if(isNotPrime[i] == false){
                for(int j=i*i;j<=n;j+=i){
                    isNotPrime[j] = true;
                }
            }
        }
        int c = 0;
        for(int i=2;i<n;i++){
            if(isNotPrime[i] == false)
                c++;
        }
        return c;
    }
}