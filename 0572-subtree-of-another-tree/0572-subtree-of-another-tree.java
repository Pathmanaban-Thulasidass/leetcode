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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> li = new ArrayList<>();
        findRoot(root,subRoot.val,li);
        for(TreeNode cur : li){
            if(helper(cur,subRoot))
                return true;
        }         
        return false;
    }
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        else if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return helper(root1.left,root2.left) && helper(root1.right,root2.right);
    }

    public void findRoot(TreeNode root,int val,List<TreeNode> li){
        if(root == null)
            return;
        if(root.val == val){
            li.add(root);
        }
        findRoot(root.left,val,li);
        findRoot(root.right,val,li);
    }
}