class Solution {
    public char kthCharacter(int k) {
        StringBuffer sb = new StringBuffer("a");
        while(sb.length() < k){
            int size = sb.length();
            for(int i=0;i<size;i++){
                sb.append((char)(sb.charAt(i) + 1));
            }
        }
        return sb.charAt(k - 1);
    }
}