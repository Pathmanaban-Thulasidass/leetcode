class Solution {
    public int binaryGap(int n) {
        int max = 0;
        int last = (int)(Math.log(n & -n) / Math.log(2)); // Rightmost Bit Index
        for(int i=last+1;i<32;i++){
            if(isSet(n,i)){
                max = Math.max(max,i-last);
                last = i;
            }
        }
        return max;
    }
    public boolean isSet(int n,int i){
        return (n & (1 << i)) != 0;
    }
}