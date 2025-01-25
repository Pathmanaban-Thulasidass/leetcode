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
    public boolean isCompleteTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int last = 0;
        queue.add(new Pair(0,root));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair curPair = queue.poll();
                TreeNode curNode = curPair.curNode;
                int curIndex = curPair.curIndex;
                if(curNode.left != null){
                    if((2 * curIndex + 1) - last != 1){
                        return false;
                    }
                    queue.add(new Pair((2 * curIndex + 1),curNode.left));
                    last = 2 * curIndex + 1;
                }

                if(curNode.right != null){
                    if((2 * curIndex + 2) - last != 1){
                        return false;
                    }
                    queue.add(new Pair((2 * curIndex + 2),curNode.right));
                    last = 2 * curIndex + 2;
                }
            }
        }
        return true;
    }    
}
class Pair{
    int curIndex;
    TreeNode curNode;
    public Pair(int curIndex,TreeNode curNode){
        this.curIndex = curIndex;
        this.curNode = curNode;
    }
}