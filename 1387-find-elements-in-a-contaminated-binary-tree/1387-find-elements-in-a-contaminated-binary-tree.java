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
class FindElements {

    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {      
        dfs(root,0);
    }

    public void dfs(TreeNode root,int val){
        set.add(val);
        if(root.left != null)
            dfs(root.left,val * 2 + 1);
        if(root.right != null)
            dfs(root.right,val * 2 + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */