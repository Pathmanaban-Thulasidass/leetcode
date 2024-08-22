import java.math.BigInteger;

class Solution {
    public int findComplement(int num) {
        BigInteger temp = BigInteger.valueOf(num);
        BigInteger mul = BigInteger.ONE;
        BigInteger r;
        BigInteger binaryNum = BigInteger.ZERO;
        BigInteger ans = BigInteger.ZERO;
        int power = 0;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            r = temp.mod(BigInteger.TWO);
            binaryNum = binaryNum.add(mul.multiply(r.xor(BigInteger.ONE)));
            mul = mul.multiply(BigInteger.TEN);
            temp = temp.divide(BigInteger.TWO);
        }
        while (binaryNum.compareTo(BigInteger.ZERO) > 0) {
            r = binaryNum.mod(BigInteger.TEN);
            ans = ans.add(r.multiply(BigInteger.valueOf((long) Math.pow(2, power))));
            power++;
            binaryNum = binaryNum.divide(BigInteger.TEN);
        }
        return ans.intValue();
    }
}
