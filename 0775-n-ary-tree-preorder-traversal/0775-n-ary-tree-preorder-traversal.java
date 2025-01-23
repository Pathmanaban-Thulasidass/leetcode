/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helperDFS(root,ans);
        return ans;
    }
    public void helperDFS(Node root,List<Integer> ans){
        if(root == null)
            return;
        ans.add(root.val);
        List<Node> childrens = root.children;
        int size = childrens.size();
        for(int i=0;i<size;i++){
            helperDFS(childrens.get(i),ans);
        }
    }
}