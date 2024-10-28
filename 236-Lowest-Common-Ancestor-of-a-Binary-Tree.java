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
        int pPtr = ancestorsOfP.size() - 1;
        int qPtr = ancestorsOfQ.size() - 1;
        while(pPtr >= 0 && qPtr >= 0){
            if(ancestorsOfP.contains(ancestorsOfQ.get(qPtr))){
                return ancestorsOfQ.get(qPtr);
            }
            else if(ancestorsOfQ.contains(ancestorsOfP.get(pPtr))){
                return ancestorsOfP.get(pPtr);
            }
            pPtr--;
            qPtr--;
        }
        return null;
    }
    //Pre-order Traversal
    public void findAncestors(TreeNode root,TreeNode val,List<TreeNode> inner,List<TreeNode> ancestors){
        if(root == null){
            return;
        }
        inner.add(root);
        if(root == val){
            ancestors.addAll(inner);
            return;
        }else{
            findAncestors(root.left,val,inner,ancestors);
            findAncestors(root.right,val,inner,ancestors);
        }
        inner.remove(inner.size() - 1);
    }
}