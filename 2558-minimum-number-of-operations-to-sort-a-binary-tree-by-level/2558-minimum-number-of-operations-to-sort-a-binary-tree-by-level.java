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
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.add(cur.left);
                    li.add(cur.left.val);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    li.add(cur.right.val);
                }
            }
            ans += minSwaps(li);
        }
        return ans; 
    }
    public int minSwaps(List<Integer> arrList) {
        int n = arrList.size();
        List<Integer> sortedList = new ArrayList<>(arrList);
        Collections.sort(sortedList);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arrList.get(i), i);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!arrList.get(i).equals(sortedList.get(i))) {
                int correctIndex = map.get(sortedList.get(i));
                Collections.swap(arrList, i, correctIndex);
                map.put(arrList.get(correctIndex), correctIndex);
                map.put(arrList.get(i), i);
                count++;
            }
        }
        return count;
    }
}