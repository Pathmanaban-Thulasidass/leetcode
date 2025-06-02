class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int count = 0;
        int ans = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '1'){
                count++;
                if(s.charAt(i+1) == '0'){
                    ans += count;
                }
            }
        }
        return ans;
    }
}