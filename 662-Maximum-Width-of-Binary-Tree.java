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
    public int widthOfBinaryTree(TreeNode root) {
        //Indexing the node
        if(root == null)
            return 0; 
        Queue<Pair> queue = new LinkedList<>();
        int ans = 0;
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            int n = queue.size();
            int min = queue.peek().index;// Always the first element has minimum indexing
            int first = 0;
            int last = 0;
            for(int i=0;i<n;i++){
                int curIndex = queue.peek().index - min;
                TreeNode curNode = queue.poll().node;
                if(i == 0)
                    first = curIndex;
                else if(i == n - 1)
                    last = curIndex;
                if(curNode.left != null){
                    queue.add(new Pair(curNode.left,curIndex * 2 + 1));
                }
                if(curNode.right != null){
                    queue.add(new Pair(curNode.right,curIndex * 2 + 2));
                }
            }
            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }
}
class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node,int index){
        this.node = node;
        this.index = index;
    }
}