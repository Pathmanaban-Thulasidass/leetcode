class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int n = strs.length;
        for(int i=0;i<n;i++){
            if(strs[i].length() == 0)
                return new String();
        }
        char c = strs[0].charAt(0);
        int cnt = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            try{
                if(strs[i].charAt(j) == c){
                    cnt++;
                }
                else{
                    return sb.toString();
                }
                if(cnt == n){
                    sb.append(c);
                    cnt = 0;
                    j++;
                    c = strs[i].charAt(j);
                    i = -1;
                }
            }
            catch(Exception e){
                return sb.toString();
            }
        }
        return sb.toString();
    }
}