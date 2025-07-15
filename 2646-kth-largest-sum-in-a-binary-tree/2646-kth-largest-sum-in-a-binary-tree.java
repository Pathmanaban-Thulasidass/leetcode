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
    PriorityQueue<Long> pq = new PriorityQueue<>();
    public long kthLargestLevelSum(TreeNode root, int k) {
        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        while(!queue.isEmpty()){
            int n = queue.size();
            long sum = 0;
            for(int i=0;i<n;i++){
                TreeNode cur = queue.poll();
                sum +=  cur.val;
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            add(sum,k);
        }
        return pq.size() == k ? pq.peek() : -1;
    }
    public void add(long val,int k){
        if(pq.size() < k){
            pq.add(val);
        }
        else{
            long temp = pq.peek();
            if(temp < val){
                pq.poll();
                pq.add(val);
            }
        }
    }
}