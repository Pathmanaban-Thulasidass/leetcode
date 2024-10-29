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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,new StringBuffer());
        return sum;
    }
    //Pre-Order Traversal
    public void helper(TreeNode root,StringBuffer sb){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(sb.toString() + root.val);
        }
        int len = sb.length();
        sb.append(root.val + \\);
        helper(root.left,sb);
        helper(root.right,sb);
        sb.setLength(len);
    }
}