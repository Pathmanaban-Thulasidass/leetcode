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
    public int pseudoPalindromicPaths (TreeNode root) {
        return helperDFS(root,0);
    }
    public int helperDFS(TreeNode root,int path){
        if(root == null)
            return 0;
        path = path ^ (1 << root.val);
        if(root.left == null && root.right == null){
            return Integer.bitCount(path) <= 1 ? 1 : 0;
        }
        int leftTree = helperDFS(root.left,path);
        int rightTree = helperDFS(root.right,path);
        return leftTree + rightTree;
    }
}