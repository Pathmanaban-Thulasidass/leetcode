class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && ((n & (n -1)) == 0) && isFourThPower(n);
    }
    public boolean isFourThPower(int n){
        int count = 0;
        boolean isOneEncountered = false;
        for(int i=0;i<32;i++){
            if(((n & (1 << i)) == 0) && !isOneEncountered)
                count++;
            else
                isOneEncountered = true;
        }
        //returning iseven
        return (count & 1) != 1;
    }
}