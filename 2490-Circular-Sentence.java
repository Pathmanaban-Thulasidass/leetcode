class Solution {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        char last = ' ';
        if(sentence.charAt(0) != sentence.charAt(n-1))
            return false;
        for(int i=1;i<n;i++){
            if(sentence.charAt(i) == ' '){
                last = sentence.charAt(i-1);
            }
            else if(sentence.charAt(i-1) == ' '){
                if(last != sentence.charAt(i))
                    return false;
            }
        }
        return true;
    }
}