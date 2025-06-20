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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(0,n - 1,nums);
    }
    public TreeNode helper(int low,int high,int[] nums){
        if(low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = helper(low,mid-1,nums);
        temp.right = helper(mid+1,high,nums);
        return temp;
    }
}