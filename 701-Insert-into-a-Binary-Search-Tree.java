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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode temp = root;
        TreeNode insert = root;
        while(temp != null){
            if(temp.val > val){
                insert = temp;
                temp = temp.left;
            }
            else{
                insert = temp;
                temp = temp.right;
            }
        }
        if(insert.val < val){
            insert.right = new TreeNode(val);
        }
        else{
            insert.left = new TreeNode(val);
        }
        return root;
    }
}