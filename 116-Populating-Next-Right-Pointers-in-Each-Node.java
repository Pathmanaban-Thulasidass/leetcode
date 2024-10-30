/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;
        while(!queue.isEmpty()){
            int n = queue.size();
            Node last = null;
            for(int i=0;i<n;i++){
                temp = queue.poll();
                if(last != null)
                    last.next = temp;
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                last = temp;
            }
            last.next = null;
        }
        return root;
    }
}