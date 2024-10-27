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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int x = 0;
        while(!queue.isEmpty()){
            int noOfNode = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<noOfNode;i++){
                if(queue.peek().left != null)
                    queue.add(queue.peek().left);
                if(queue.peek().right != null)
                    queue.add(queue.peek().right);
                if(x == 1) // Backward
                    inner.add(0,queue.poll().val);
                else // forward
                    inner.add(queue.poll().val);
            }
            ans.add(inner);
            x = x ^ 0 ^ 1;
        }
        return ans;
    }
}