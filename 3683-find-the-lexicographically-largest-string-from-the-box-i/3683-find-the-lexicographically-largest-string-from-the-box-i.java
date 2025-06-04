class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1)
            return word;
        String ans = "";
        int strLen = n - (numFriends - 1);
        for(int i=0;i<n;i++){
            int end = Math.min(i + strLen, n);
            String inner = word.substring(i,end);
            if(ans.compareTo(inner) < 0){
                ans = inner;
            }
        }
        return ans;
    }
}