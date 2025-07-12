class Solution {
    public String validIPAddress(String queryIP) {
        if(isIPV4(queryIP))
            return "IPv4";
        else if(isIPV6(queryIP))
            return "IPv6";
        return "Neither";
    }
    public boolean isIPV4(String queryIP){
        int n = queryIP.length();
        String sArr[] = queryIP.split("\\.");
        if(sArr.length != 4)
            return false;
        if(queryIP.charAt(n - 1) == '.' || queryIP.charAt(0) == '.')
            return false;
        for(String part : sArr){
            int len = part.length();
            if(len < 1 || len > 3)
                return false;
            if(len > 1 && part.charAt(0) == '0'){
                return false;
            }
            try{
                int temp = Integer.parseInt(part);
                if(0 > temp || temp > 255)
                    return false;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean isIPV6(String queryIP){
        int n = queryIP.length();
        String sArr[] = queryIP.split(":");
        System.out.println(Arrays.toString(sArr));
        if(sArr.length != 8)
            return false;
        if(queryIP.charAt(n - 1) == ':' || queryIP.charAt(0) == ':')
            return false;
        for(String part : sArr){
            int len = part.length();
            if(len < 1 || len > 4)
                return false;
            if(!isAlphaNumberic(part)){
                return false;
            }
        }
        return true;
    }
    public boolean isAlphaNumberic(String s){
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                if(!(ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd' || ch == 'e' || ch == 'f' || ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F')){
                    return false;
                }
            }
            else if(Character.isDigit(ch)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}