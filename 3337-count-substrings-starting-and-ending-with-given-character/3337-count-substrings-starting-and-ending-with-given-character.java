class Solution {
    public long countSubstrings(String s, char c) {
        int n = s.length();
        long ans = 0;
        int right = 0;
        int charCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == c)
                charCount++;
        }
        while(right < n){
            if(s.charAt(right) == c){
                ans += charCount;
                charCount--;
            }
            right++;
        }
        return ans;
    }
}