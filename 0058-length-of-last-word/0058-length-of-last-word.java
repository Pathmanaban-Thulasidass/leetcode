class Solution {
    public int lengthOfLastWord(String str) {
        int c = 0;
        int flag = 0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)!=' '){
                c++;
                flag = 1;
            }
            if(str.charAt(i)== ' ' && flag == 1){
                break;
            }
        }
        return c;
    }
}