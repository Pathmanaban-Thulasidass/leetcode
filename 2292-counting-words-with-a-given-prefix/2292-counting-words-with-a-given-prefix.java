class Solution {
    TrieNode root = new TrieNode();
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int count = 0;
        //Creating Trie
        insert(pref);
        for(int i=0;i<n;i++){
            if(startsWith(words[i]))
                count++;
        }
        return count;       
    }
    public void insert(String pref){
        int n = pref.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int ind = pref.charAt(i) - 'a';
            if(temp.nodes[ind] == null)
                temp.nodes[ind] = new TrieNode();
            temp = temp.nodes[ind];
        }
        temp.isEnd = true;
    }

    public boolean startsWith(String word){
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int ind = word.charAt(i) - 'a';
            if(temp.nodes[ind] == null)
                return false;
            temp = temp.nodes[ind];
            if(temp.isEnd)
                return true;
        }
        return false;
    }

}
public class TrieNode{
    TrieNode[] nodes;
    boolean isEnd;
    public TrieNode(){
        nodes = new TrieNode[26];
    }
}