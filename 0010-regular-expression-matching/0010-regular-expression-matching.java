class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        return helper(n1-1,n2-1,s,p);
    }
    public boolean helper(int i,int j,String s, String p){
        if(i <= -1 && j <= -1)
            return true;
        if(j <= -1)
            return false;
        if(i >= 0 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            if(helper(i-1,j-1,s,p))
                return true;
        }

        if(p.charAt(j) == '*'){
            if(helper(i,j-2,s,p))
                return true;
            if(i >= 0 && (p.charAt(j - 1) == s.charAt(i)  || p.charAt(j - 1) == '.')){
                if(helper(i-1,j,s,p))
                    return true;
            }
        }
        return false;
    }
}