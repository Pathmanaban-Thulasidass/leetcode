/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        //Firstly find Backward (Parent) node
        Map<TreeNode,TreeNode> backwardMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
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
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int curDis = 0;
        while (!queue.isEmpty()) {
            if (curDis == k) {
                for (TreeNode node : queue) {
                    ans.add(node.val);
                }
                return ans;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Move to left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.add(node.left);
                }

                // Move to right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.add(node.right);
                }

                // Move to parent node
                if (backwardMap.containsKey(node) && !visited.contains(backwardMap.get(node))) {
                    visited.add(backwardMap.get(node));
                    queue.add(backwardMap.get(node));
                }
            }
            curDis++;
        }
        return ans;
    }
}
