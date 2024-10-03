public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a = 0;
        int b = 31;
        while(a < b){
            if(((n & (1 << a)) != 0) && ((n & (1 << b)) != 0)){
                //Both a ans b th index is 1
            }
            else if(((n & (1 << a)) == 0 && ((n & (1 << b)) == 0))){
                //Both a ans b th index is 0
            }
            else{
                //flip both the a and b pointers
                n = n ^ (1 << a);
                n = n ^ (1 << b);
            }
            a++;
            b--;
        }
        return n;
    }
}