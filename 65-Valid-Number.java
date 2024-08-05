class Solution {
    public boolean isNumber(String s) {
        boolean isSignedVisited = false;
        boolean isEVisited = false;
        int digitCount = 0;
        int dot = 0;
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                digitCount++;
            }
            else if(c == '+'){
                if(isSignedVisited && !isEVisited){
                    return false;
                }
                if(i>0 && i< s.length() && s.charAt(i-1) <= '9' && s.charAt(i-1) >= '0'){
                    return false;
                }
                else if(i == s.length() - 1){
                    return false;
                }
                isSignedVisited = true;
            }
            else if(c == '-'){
                if(isSignedVisited && !isEVisited){
                    return false;
                }
                if(i>0 && i< s.length() && s.charAt(i-1) <= '9' && s.charAt(i-1) >= '0'){
                    return false;
                }
                else if(i == s.length() - 1){
                    return false;
                }
                isSignedVisited = true;
            }
            else if(c == '.'){
                dot++;
                if(i+1>0 && i+1< s.length() && (s.charAt(i+1) == '-' || s.charAt(i+1) == '+')){
                    return false;
                }
                if(dot > 1)
                    return false;
                if(isEVisited)
                    return false;
            }
            else if(c == 'e' || c == 'E'){
                if(digitCount <= 0 || isEVisited){
                    return false;
                }
                if(i == s.length() - 1 || i == 0)
                    return false;
                if(dot > 0 && digitCount == 0)
                    return false;
                isEVisited = true;
            }
            else{
                return false;
            }
        }
        if(dot == s.length() || digitCount == 0)
            return false;
        return true;
    }
}