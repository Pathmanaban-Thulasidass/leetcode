class Solution {
    public String countAndSay(int n) {
        return helper(n).toString();
    }
    public StringBuffer helper(int n){
        if(n == 1)
            return new StringBuffer("1");
        StringBuffer sb = helper(n - 1);
        StringBuffer ans = new StringBuffer();
        int size = sb.length();
        int count = 1; 
        for(int i=0;i<size-1;i++){
            if(sb.charAt(i) != sb.charAt(i+1)){
                ans.append(count);
                ans.append(sb.charAt(i));
                count = 1;
            }
            else{
                count++;
            }
        }
        ans.append(count);
        ans.append(sb.charAt(size - 1));
        return ans;
    }
}