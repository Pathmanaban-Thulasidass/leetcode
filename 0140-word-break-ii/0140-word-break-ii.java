class Solution {
    TrieNode root = new TrieNode();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n1 = s.length();
        int n2 = wordDict.size();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n2;i++){
            insert(wordDict.get(i));
        }
        helper(0,n1 - 1,s,new ArrayList<>(),ans);
        return ans;
    }

    public void helper(int startIndex,int endIndex,String s,List<String> inner,List<String> ans){
        TrieNode temp = root; 
        if(startIndex == endIndex + 1){
            StringBuffer sb = new StringBuffer();
            for(String word : inner){
                sb.append(word + " ");
            }
            sb.setLength(sb.length() - 1);
            ans.add(sb.toString());
        }
        for(int i=startIndex;i<=endIndex;i++){
            int ind = s.charAt(i) - 'a';
            if(temp.childs[ind] != null){
                temp = temp.childs[ind];
                if(temp.isEnd){
                    inner.add(s.substring(startIndex,i+1));
                    helper(i+1,endIndex,s,inner,ans);
                    inner.remove(inner.size() - 1);
                }
            } 
            else{
                return;
            }
        }
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