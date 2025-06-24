class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        String ans = "";
        for(int i=0;i<n;i++){
            String temp = helper(i,n,s);
            if(temp.length() > maxLen){
                maxLen = temp.length();
                ans = temp;
            }
        }
        return ans;
    }
    public String helper(int index,int n,String s){
        int right = index;
        int left = index - 1;
        while(right < n && s.charAt(index) == s.charAt(right)){
            right++;
        }
        while(isValidIndex(left,right,n) && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        left++;
        return s.substring(left,right);
    }
    public boolean isValidIndex(int i,int j,int n){
        return 0 <= i && i < n && 0 <= j && j < n;
    }
}