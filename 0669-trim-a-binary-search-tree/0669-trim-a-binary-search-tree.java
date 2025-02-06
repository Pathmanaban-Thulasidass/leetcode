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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helperDFS(root,low,high);
    }
    public TreeNode helperDFS(TreeNode root,int low,int high){
        if(root == null)
            return null;
        if(root.val < low){
            return helperDFS(root.right,low,high);
        }
        if(root.val > high){
            return helperDFS(root.left,low,high);
        }
        root.left = helperDFS(root.left,low,high);
        root.right = helperDFS(root.right,low,high);
        return root;
    }
}