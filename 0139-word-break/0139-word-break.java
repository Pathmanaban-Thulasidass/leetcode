class Solution {
    TrieNode root = new TrieNode();
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        int size = s.length() - 1;
        for(int i=0;i<n;i++){
            insert(wordDict.get(i));
        }
        return helper(0,size,s,new Boolean[size + 2]);
    }

    public boolean helper(int startIndex,int endIndex,String s,Boolean dp[]){
        TrieNode temp = root; 
        boolean result = false;
        int i;
        if(dp[startIndex] != null)
            return dp[startIndex];
        for(i=startIndex;i<=endIndex;i++){
            int ind = s.charAt(i) - 'a';
            if(temp.childs[ind] != null){
                temp = temp.childs[ind];
                if(temp.isEnd){
                    result = helper(i+1,endIndex,s,dp);
                }
                if(result)
                    return dp[startIndex] = true;
            } 
            else{
                return dp[startIndex] = false;
            }
        }
        return dp[startIndex] = temp.isEnd;
    }

    public void insert(String word){
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int ind = word.charAt(i) - 'a';
            if(temp.childs[ind] == null){
                temp.childs[ind] = new TrieNode();
            }
            temp = temp.childs[ind];
        }
        temp.isEnd = true;
    }
}
class TrieNode{
    TrieNode childs[];
    boolean isEnd;
    public TrieNode(){
        childs = new TrieNode[26];
    }
}