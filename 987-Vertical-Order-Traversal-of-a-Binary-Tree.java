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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        map.put(0,new ArrayList<>(List.of(root.val)));
        while(!queue.isEmpty()){
            int n = queue.size();
            Map<Integer,PriorityQueue<Integer>> innerMap = new HashMap<>();
            for(int i=0;i<n;i++){
                Pair pair = queue.poll();
                TreeNode curNode = pair.node;
                int curIndex = pair.index;
                if(curNode.left != null){
                    queue.add(new Pair(curNode.left,curIndex - 1));
                    if(innerMap.get(curIndex - 1) == null){
                        innerMap.put(curIndex - 1,new PriorityQueue<>(List.of(curNode.left.val)));
                    }
                    else{
                        PriorityQueue<Integer> inner = innerMap.get(curIndex - 1);
                        inner.add(curNode.left.val);
                        innerMap.put(curIndex - 1,inner);
                    }
                }
                if(curNode.right != null){
                    queue.add(new Pair(curNode.right,curIndex + 1));
                    if(innerMap.get(curIndex + 1) == null){
                        innerMap.put(curIndex + 1,new PriorityQueue<>(List.of(curNode.right.val)));
                    }
                    else{
                        PriorityQueue<Integer> inner = innerMap.get(curIndex + 1);
                        inner.add(curNode.right.val);
                        innerMap.put(curIndex + 1,inner);
                    }
                }
            }
            for(int key : innerMap.keySet()){
                PriorityQueue<Integer> pq = innerMap.get(key);
                while(!pq.isEmpty()){
                    if(map.get(key) == null){
                        map.put(key,new ArrayList<>(List.of(pq.poll())));
                    }
                    else{
                        List<Integer> inner = map.get(key);
                        inner.add(pq.poll());
                        map.put(key,inner);
                    }
                }
            }
        }
        for(int key : map.keySet()){
            ans.add(map.get(key));
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