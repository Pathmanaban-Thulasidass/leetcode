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
    int i = 0;
    int n = 0;
    List<Integer> li = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        helper(root1);
        return helper2(root2) && n == 0;
    }
    public void helper(TreeNode root){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            li.add(root.val);
            n++;
            return;
        }
        helper(root.left);
        helper(root.right);        
    }
    public boolean helper2(TreeNode root){
        if(root == null)
            return true;
        if(root.left == null && root.right == null){
            if(n > 0 && root.val == li.get(i)){ 
                i++;
                n--;
                return true;
            }
            i++;
            n--;
            return false;
        }
        if(!helper2(root.left))
            return false;
        if(!helper2(root.right))
            return false;
        return true;
    }
}