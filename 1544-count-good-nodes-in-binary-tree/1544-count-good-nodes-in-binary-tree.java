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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return ans;
    }
    public void helper(TreeNode root,int max){
        if(root == null)
            return;
        if(max <= root.val){
            ans++;
        }
        helper(root.left,Math.max(max,root.val));
        helper(root.right,Math.max(max,root.val));
    }
}
