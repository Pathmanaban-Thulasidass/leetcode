class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left; i <= right ;i++){
            if(isPrime(Integer.bitCount(i)))
                ans++;
        }
        return ans;
    }
    public boolean isPrime(int n){
        if(n == 1)
            return false;
        else if(n == 2)
            return true;
        int size = (int)Math.sqrt(n);
        for(int i=2;i<=size;i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}