class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE)
            return false;
        return ((long)n & (long)(n-1)) == 0;
    }
}