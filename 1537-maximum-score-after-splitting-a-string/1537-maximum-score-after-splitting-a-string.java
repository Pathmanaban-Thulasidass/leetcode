class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1')
                ones++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '1')
                ones--;
            else
                zeros++;
            max = Math.max(max,(ones + zeros));
        }
        return max;
    }
}