/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    TreeNode root;
    List<TreeNode> inorder = new ArrayList<>();
    int pointer = 0;
    public BSTIterator(TreeNode root) {
        this.root = root;
        helper(root);
    }
    public int next() {
        return inorder.get(pointer++).val;
    }
    
    public boolean hasNext() {
        return pointer < inorder.size();
    }
    
    public void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        inorder.add(root);
        helper(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */