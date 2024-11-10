class Solution {
    public long minEnd(int n, int x) {
        long tempX = x;
        n--;
        int i = 0;
        while(n > 0){
            if(((1L << i) & tempX) == 0){
                int lastBit = n & 1;
                if(lastBit == 1){
                    tempX = tempX ^ (1L << i);   
                }
                n /= 2;
            }
            i++;
        }
        return tempX;
    }
}