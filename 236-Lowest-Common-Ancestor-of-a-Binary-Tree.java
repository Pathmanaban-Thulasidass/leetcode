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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancestorsOfP = new ArrayList<>();
        List<TreeNode> ancestorsOfQ = new ArrayList<>();
        findAncestors(root,p,new ArrayList<>(),ancestorsOfP);
        findAncestors(root,q,new ArrayList<>(),ancestorsOfQ);
        if(ancestorsOfP.contains(q)){
            return q;
        }
        else if(ancestorsOfQ.contains(p)){
            return p;
        }
        int i = 0;
        TreeNode ans = null;
        while(i < ancestorsOfP.size() && i < ancestorsOfQ.size()){
            if(ancestorsOfP.get(i) == ancestorsOfQ.get(i)){
                ans = ancestorsOfP.get(i);
                i++;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
    //Pre-order Traversal
    public void findAncestors(TreeNode root,TreeNode val,List<TreeNode> inner,List<TreeNode> ancestors){
        if(root == null){
            return;
        }
        if(root == val){
            ancestors.addAll(inner);
            return;
        }
        inner.add(root);
        findAncestors(root.left,val,inner,ancestors);
        findAncestors(root.right,val,inner,ancestors);
        inner.remove(inner.size() - 1);
    }
}