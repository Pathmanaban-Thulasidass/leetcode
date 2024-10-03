class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDis = 0;
        for(int i=0;i<32;i++){
            if(isSet(x,i) != isSet(y,i)){
                hammingDis++;
            }
        }
        return hammingDis;
    }
    public boolean isSet(int n,int index){
        return (n & (1 << index)) != 0;
    }
}