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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> backwardMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode target = null;
        int noOfNodes = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            noOfNodes += n;
            for(int i=0;i<n;i++){
                if(queue.peek().val == start)
                    target = queue.peek();
                if(queue.peek().left != null){
                    backwardMap.put(queue.peek().left,queue.peek());
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    backwardMap.put(queue.peek().right,queue.peek());
                    queue.add(queue.peek().right);
                }
                queue.poll();
            }
        }
        Map<TreeNode,Boolean> visited = new HashMap<>();
        queue.add(target);
        visited.put(target,true);
        int time = 0;
        while(!queue.isEmpty()){
            if(noOfNodes == visited.size()){
                return time;
            }
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode temp = queue.poll();
                //Move Left
                if(temp.left != null && visited.get(temp.left) == null){
                    visited.put(temp.left,true);
                    queue.add(temp.left);
                }
                //Move right
                if(temp.right != null && visited.get(temp.right) == null){
                    visited.put(temp.right,true);
                    queue.add(temp.right);
                }
                //Move to Parent
                if(backwardMap.containsKey(temp) && visited.get(backwardMap.get(temp)) == null){
                    visited.put(backwardMap.get(temp),true);
                    queue.add(backwardMap.get(temp));
                }
            }
            time++;
        }
        return time;
    }
}