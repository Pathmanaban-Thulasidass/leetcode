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
    int childLevel = -1;
    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helperDFS(0,traversal.length(),traversal);
    }
    public TreeNode helperDFS(int level,int n,String s){
        if(i >= n)
            return null;
        int valTemp[] = findVal(i,n,s);
        int val = valTemp[0];
        int valLen = valTemp[1];
        childLevel = findLevel(i + valLen,n,s);
        TreeNode root = new TreeNode(val);
        i = i + valLen + childLevel;
        if(level + 1 == childLevel){
            root.left = helperDFS(level + 1,n,s);
        }
    
        if(level + 1 == childLevel){
            root.right = helperDFS(level + 1,n,s);
        }
        
        return root;
    }
    public int findLevel(int i,int n,String s){
        int count = 0;
        for(int j=i;j<n;j++){
            if(s.charAt(j) == '-')
                count++;
            else
                return count;
        }
        return count;
    }
    public int[] findVal(int i,int n,String s){
        StringBuffer sb = new StringBuffer();
        for(int j=i;j<n;j++){
            char ch = s.charAt(j);
            if(ch != '-'){
                sb.append(ch);
            }
            else{
                return new int[]{Integer.parseInt(sb.toString()),sb.length()};
            }
        }
        return new int[]{Integer.parseInt(sb.toString()),sb.length()};
    }
}