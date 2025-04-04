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
    int max = 0;
    TreeNode ans = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public int helper(TreeNode root,int level){
        if(root == null)
            return 0;
        int left = helper(root.left,level + 1);
        int right = helper(root.right,level + 1);
        if(left == right && max <= (left + level + 1)){
            max = (left + level + 1);
            ans = root;
        }
        return Math.max(left,right) + 1;
    }
}