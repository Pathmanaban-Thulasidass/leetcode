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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                max = Math.max(max,cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}