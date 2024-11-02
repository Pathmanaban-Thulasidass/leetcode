class Solution {
    public String makeFancyString(String s) {
        StringBuffer sb = new StringBuffer();
        int sameCount = 0;
        char prev = s.charAt(0);
        for(char cur : s.toCharArray()){
            if(prev == cur){
                sameCount++;
            }
            else{
                sameCount = 1;
            }
            if(sameCount < 3)
                sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }
}