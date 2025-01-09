class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int ind = word.charAt(i) - 'a';
            if(temp.nodes[ind] == null)
                temp.nodes[ind] = new TrieNode();
            temp = temp.nodes[ind];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int ind = word.charAt(i) - 'a';
            if(temp.nodes[ind] == null)
                return false;
            temp = temp.nodes[ind];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int ind = prefix.charAt(i) - 'a';
            if(temp.nodes[ind] == null)
                return false;
            temp = temp.nodes[ind];
        }
        return true;
    }

}
class TrieNode{
    TrieNode nodes[];
    boolean isEnd;
    public TrieNode(){
        nodes = new TrieNode[26];
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */