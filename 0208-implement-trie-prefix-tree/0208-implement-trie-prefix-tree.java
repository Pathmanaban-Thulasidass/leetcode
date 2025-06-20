class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int index = word.charAt(i) - 'a';
            if(temp.nodes[index] == null){
                temp.nodes[index] = new TrieNode();
            }
            temp = temp.nodes[index];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int index = word.charAt(i) - 'a';
            if(temp.nodes[index] == null){
                return false;
            }
            temp = temp.nodes[index];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int index = prefix.charAt(i) - 'a';
            if(temp.nodes[index] == null){
                return false;
            }
            temp = temp.nodes[index];
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