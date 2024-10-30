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
    public void flatten(TreeNode root) {
        helper(root);
    }
    //Pre-Order Traversal
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = null; 
        if(root.left != null){
            temp = root.right;
            root.right = root.left;
            root.left = null;
        }  
        helper(root.right);
        if(temp != null){
            TreeNode node = root;
            while(node.right != null){
                node = node.right;
            }
            node.right = temp;
            helper(node);
        }
    }
}