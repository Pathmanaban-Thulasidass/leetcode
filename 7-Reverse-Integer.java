class Solution {
    public int reverse(int x) {
        long ans =0 ;
        int n = x;
        if(x < 0)
            n = -1 * n;
        while(n>0){
            ans = ans * 10 + (n%10);
            n /= 10;
        }
        if (ans > Integer.MAX_VALUE) return 0;
        if (x < 0) return (int)(-ans);
        return (int)ans ;
    }
}