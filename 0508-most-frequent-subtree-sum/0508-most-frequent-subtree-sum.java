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
    int maxFreq = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        findSum(root,map);
        List<Integer> li = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq){
                li.add(key);
            }
        }
        int n = li.size(); 
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = li.get(i);
        }
        return ans;
    }
    public int findSum(TreeNode root,Map<Integer,Integer> map){
        if(root == null)
            return 0;
        int leftSum = findSum(root.left,map);
        int rightSum = findSum(root.right,map);
        int curSum = leftSum + rightSum + root.val;
        map.put(curSum, map.getOrDefault(curSum,0) + 1);
        maxFreq = Math.max(maxFreq,map.get(curSum));
        return curSum;
    }
}