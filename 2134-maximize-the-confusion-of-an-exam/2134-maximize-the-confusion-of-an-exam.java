class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int trueCount = 0;
        int falseCount = 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < n){
            char ch = answerKey.charAt(right);
            if(ch == 'T'){
                trueCount++;
            }
            else{
                falseCount++;
            }
            while(left <= right && trueCount > k){
                ch = answerKey.charAt(left);
                if(ch == 'T'){
                    trueCount--;
                }
                else{
                    falseCount--;
                }
                left++;
            }
            ans = Math.max(ans,right - left + 1);
            right++;
        } 
        left = 0;
        right = 0;
        trueCount = 0;
        falseCount = 0;
        while(right < n){
            char ch = answerKey.charAt(right);
            if(ch == 'T'){
                trueCount++;
            }
            else{
                falseCount++;
            }
            while(left <= right && falseCount > k){
                ch = answerKey.charAt(left);
                if(ch == 'T'){
                    trueCount--;
                }
                else{
                    falseCount--;
                }
                left++;
            }
            ans = Math.max(ans,right - left + 1);
            right++;
        } 
        return ans;
    }
}