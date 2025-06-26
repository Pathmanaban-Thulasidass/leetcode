class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeros = 0;
        long num = 0;
        int bit = 0;
        int ones = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '0'){
                zeros++;
                bit++;
            }
            else{
                if(bit < 32){
                    long temp = num ^ (1L << bit);
                    if(temp <= k){
                        bit++;
                        ones++;
                        num = temp;
                    }
                }
            }
        }
        return zeros + ones;
    }
}