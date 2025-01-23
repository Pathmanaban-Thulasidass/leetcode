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
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    public int[] helper(TreeNode root){
        if(root == null)
            return new int[]{0,0};//Sum, No. of Elements
        int leftTree[] = helper(root.left);
        int rightTree[] = helper(root.right);
        int sum = leftTree[0] + rightTree[0] + root.val;
        int ele = leftTree[1] + rightTree[1] + 1;
        if(ele != 0 && root.val == (sum / ele)){
            ans++;
        }
        return new int[]{sum,ele};
    }
}