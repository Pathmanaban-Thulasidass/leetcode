class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        helper(0,n,0,s,new StringBuffer(),ans);
        return ans;
    }
    public void helper(int index,int n,int part,String s,StringBuffer inner,List<String> ans){
        if(part > 4)
            return;
        if(index == n){
            int tempLen = inner.length();
            inner.setLength(tempLen - 1);
            if(part == 4){
                if(isValidIp(inner)){
                    ans.add(inner.toString());
                }       
            }
            return;
        }
        for(int i=index;i<n;i++){
            inner.append(s.charAt(i));
            int len = inner.length();
            inner.append('.');
            helper(i+1,n,part + 1,s,inner,ans);
            inner.setLength(len);
        }

    }
    public boolean isValidIp(StringBuffer sb) {
        String[] parts = sb.toString().split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3)
                return false;

            if (part.length() > 1 && part.charAt(0) == '0') 
                return false;

            int num = 0;
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
                num = num * 10 + (c - '0');
            }

            if (num < 0 || num > 255) return false;
        }
        return true;
    }

}