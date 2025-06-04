class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1)
            return word;
        String ans = "";
        int strLen = n - (numFriends - 1);
        for(int i=0;i<=n-strLen;i++){
            String inner = word.substring(i,i+strLen);
            if(ans.compareTo(inner) < 0){
                ans = inner;
            }
        }
        for(int i=n-strLen + 1;i<n;i++){
            String inner = word.substring(i,n);
            if(ans.compareTo(inner) < 0){
                ans = inner;
            }
        }
        for(int i=0;i<n;i++){
            String inner = String.valueOf(word.charAt(i));
            if(ans.compareTo(inner) < 0){
                ans = inner;
            }
        }
        return ans;
    }
}