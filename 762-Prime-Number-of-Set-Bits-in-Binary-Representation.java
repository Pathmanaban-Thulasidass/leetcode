class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left; i <= right ;i++){
            if(isPrime(countBits(i)))
                ans++;
        }
        return ans;
    }
    public int countBits(int n){
        int count = 0;
        for(int i=0;i<32;i++){
            if((n & (1 << i)) != 0)
                count++;
        }
        return count;
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