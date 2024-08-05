class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int f = 10;
        boolean isNegative = false;
        boolean isContWhiteSpace = true;
        boolean signVisited = false;
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c == ' '){
                if(!isContWhiteSpace){
                    if(isNegative)
                        ans *= -1;
                    return (int)ans;
                }       
            }
            else if(c == '-'){
                if(signVisited){
                    if(isNegative)
                        ans *= -1;
                    return (int)ans;
                }
                if(!isContWhiteSpace){
                    if(isNegative)
                        ans *= -1;
                    return (int)ans;
                }
                isNegative = true;
                signVisited = true;
                    
            }
            else if(c == '+'){
                if(signVisited){
                    if(isNegative)
                        ans *= -1;
                    return (int)ans;
                }
                signVisited = true;
                if(!isContWhiteSpace)
                    return (int)ans;
                isContWhiteSpace = false;
            }
            else if(c >= '0' && c <= '9'){
                isContWhiteSpace = false;
                ans = (f * ans) + (c - '0');
            }
            else{
                isContWhiteSpace = false;
                if(isNegative)
                    ans *= -1;
                return (int)ans;
            }
            if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
                if(isNegative)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            if(isNegative)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        if(isNegative)
            ans *= -1;
        return (int)ans;
    }
}