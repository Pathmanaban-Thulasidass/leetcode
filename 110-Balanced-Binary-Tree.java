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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return preOrder(root);
    }
    public boolean preOrder(TreeNode root){
        if(root == null)
            return true;
        if(Math.abs(maxHeight(root.left) - maxHeight(root.right)) > 1)
            return false;
        return preOrder(root.left) && preOrder(root.right);
    } 
    public int maxHeight(TreeNode root){
        if(root == null)
            return 0;
        int height = 1;
        height += Math.max(maxHeight(root.left),maxHeight(root.right));
        return height;
    }
}