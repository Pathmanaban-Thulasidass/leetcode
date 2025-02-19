class Solution {
    int k = 0;
    public String getHappyString(int n, int k) {
        this.k = k;
        List<String> li = new ArrayList<>();
        helperPermutation(-1,n,"abc",new StringBuffer(),li);
        return li.size() >= k ? li.get(k - 1) : "";
    }
    public void helperPermutation(int lastIndex,int n,String s,StringBuffer sb,List<String> li){
        if(li.size() >= k)
            return;
        if(sb.length() == n){
            li.add(sb.toString());
            return;
        }
        for(int i=0;i<3;i++){
            if(i != lastIndex){
                int tempLen = sb.length();
                sb.append(s.charAt(i));
                helperPermutation(i,n,s,sb,li);
                sb.setLength(tempLen);
            }
        }
    }
}