class Solution {
    public int minimizeXor(int num1, int num2) {
        int n1 = Integer.bitCount(num1);
        int n2 = Integer.bitCount(num2);
        int ans = 0;
        int req = 0;
        if(n1 == n2)
            return num1;
        else if(n1 < n2){
            ans = num1;
            req = n2 - n1;
            for(int i=0;i<32 && req > 0;i++){
                if((ans & (1 << i)) == 0){
                    ans = ans | 1 << i;
                    req--;
                }
            }
            return ans;
        }
        else{
            req = n1 - n2; // Number of bits to unset
            for (int i = 0; i < 32; i++) {
                if ((num1 & (1 << i)) != 0) {
                    if (req > 0) {
                        req--;
                    } else {
                        ans |= (1 << i); 
                    }
                }
            }
            return ans;
        }
        

       
        

    }

}
// req = n1 - n2; // Required Bits to Set
//         for(int i=31;i>=0 && req > 0;i--){
//             if((num1 & (1 << i)) != 0){
//                 ans = ans | 1 << i;
//                 req--;
//             }
//         }
//         return ans;
