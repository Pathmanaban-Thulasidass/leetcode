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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(new StringBuilder(), root, ans);
        return ans;
    }

    // Pre-order traversal
    public void helper(StringBuilder sb, TreeNode root, List<String> ans) {
        if (root == null) {
            return;
        }
        
        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) { // If it's a leaf node
            ans.add(sb.toString());
        } else { // If it's not a leaf, add the separator and continue
            sb.append(\->\);
            helper(sb, root.left, ans);
            helper(sb, root.right, ans);
        }
        
        sb.setLength(len); // Backtrack to the previous state
    }
}
