class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (int)Math.ceil(n / (double)k);
        String[] ans = new String[size];
        int j = 0;
        for(int i=0;i<n;i++){
            ans[j++] = s.substring(i,Math.min(i+k,n));
            i += k - 1;
        }
        while(ans[size - 1].length() < k){
            ans[size - 1] = ans[size - 1] + fill + "";
        }
        return ans;
    }
}