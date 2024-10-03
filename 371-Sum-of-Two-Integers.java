class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = a;
            a = temp ^ b; // Sum
            b = (temp & b) << 1; // Carry
        }
        return a;
    }
}