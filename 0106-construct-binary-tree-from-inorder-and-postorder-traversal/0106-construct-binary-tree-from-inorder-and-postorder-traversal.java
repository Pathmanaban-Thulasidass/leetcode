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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return helper(0,n-1,0,n-1,postorder,inorder,map);
    }
    public TreeNode helper(int postStart,int postEnd,int inStart,int inEnd,int[] postorder, int[] inorder,Map<Integer,Integer> map){
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postEnd]);
        int rootIndex = map.get(postorder[postEnd]);
        int leftTreeSize = rootIndex - inStart;

        cur.left = helper(postStart,postStart + leftTreeSize - 1,inStart,rootIndex - 1,postorder,inorder,map);
        cur.right = helper(postStart + leftTreeSize,postEnd - 1,rootIndex + 1,inEnd,postorder,inorder,map);

        return cur;
    }
}