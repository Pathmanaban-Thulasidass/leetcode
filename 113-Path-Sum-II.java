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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,targetSum,root,new ArrayList<>(),ans);
        return ans;
    }
    //Pre-Order traversal
    public void helper(int curSum,int target,TreeNode root,List<Integer> inner,List<List<Integer>> ans){
        if(root == null){
            return;
        }
        inner.add(root.val);
        if(root.left == null && root.right == null){
            if(curSum + root.val == target){
                ans.add(new ArrayList<>(inner));
            }
        }
        helper(curSum + root.val,target,root.left,inner,ans);
        helper(curSum + root.val,target,root.right,inner,ans);
        inner.remove(inner.size() - 1);
    }
}