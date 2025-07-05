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
    public String tree2str(TreeNode root) {
        String temp = helper(root);
        temp = temp.substring(1,temp.length() - 1);
        return temp;
    }
    public String helper(TreeNode root){
        if(root == null)
            return "";
        String leftTree = helper(root.left);
        if(root.left == null && root.right != null){
            leftTree = "()";
        }
        String rightTree = helper(root.right);
        return "(" + root.val + leftTree + rightTree + ")";
    }
}