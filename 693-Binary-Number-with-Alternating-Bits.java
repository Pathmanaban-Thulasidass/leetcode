class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        int cur = 0;
        n /= 2;
        while(n > 0){
            cur = n & 1;
            if(prev == cur)
                return false;
            prev = cur;
            n /= 2;
        }
        return true;
    }
    
}