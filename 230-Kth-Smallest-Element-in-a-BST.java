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
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return pq.peek();
    }
    public void helper(TreeNode root,int k){
        if(root == null)
            return;
        add(root.val,k);
        helper(root.left,k);
        helper(root.right,k);
    }
    public void add(int val,int k){
        if(pq.size() == k && pq.peek() >= val){
            pq.poll();
            pq.add(val);
        }
        else if(pq.size() < k){
            pq.add(val);
        }
    } 
}