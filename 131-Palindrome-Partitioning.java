class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        findSubSequences(0,s,new ArrayList<>(),ans);
        return ans;
    }
    public void findSubSequences(int startIndex,String s,List<String> inner,List<List<String>> ans){
        if(startIndex == s.length()){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int i = startIndex;i<s.length();i++){
            if(isPalindrome(s,startIndex,i)){
                inner.add(s.substring(startIndex,i+1));
                findSubSequences(i+1,s,inner,ans);
                inner.remove(inner.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s,int a,int b){
        while(a <= b){
            if(s.charAt(a++) != s.charAt(b--))
                return false;
        }
        return true;
    }
}