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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root,ans);
        return ans;
    }
    public void preOrder(TreeNode root,List<Integer> inner){
        if(root == null)
            return;
        inner.add(root.val);
        preOrder(root.left,inner);
        preOrder(root.right,inner);
    }
}