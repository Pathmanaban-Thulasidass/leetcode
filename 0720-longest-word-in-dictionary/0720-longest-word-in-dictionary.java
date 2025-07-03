class Solution {
    int maxLen = 0;
    String ans = "";
    public String longestWord(String[] words) {
        int n = words.length;
        TrieNode root = new TrieNode();
        for(int i=0;i<n;i++){
            int len = words[i].length();
            TrieNode temp = root;
            for(int j=0;j<len;j++){
                int index = (words[i].charAt(j) - 'a');
                if(temp.childs[index] == null)
                    temp.childs[index] = new TrieNode();
                temp = temp.childs[index];
            }
            temp.isEnd = true;
        }
        helper(root,"");
        return ans;
    }
    public void helper(TrieNode root,String s){
        if(maxLen < s.length()){
            maxLen = s.length();
            ans = s;
        }
        else if(maxLen == s.length()){
            if(ans.compareTo(s) > 0){
                ans = s;
            }
        }
        for(int i=0;i<26;i++){
            if(root.childs[i] != null && root.childs[i].isEnd == true){
                helper(root.childs[i],s + "" + (char)(i + 'a'));
            }
        }
    }
}
class TrieNode{
    TrieNode childs[];
    boolean isEnd;
    public TrieNode(){
        childs = new TrieNode[26];
    }
}