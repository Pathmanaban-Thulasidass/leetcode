/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return \\;
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + \,\);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                    sb.append(temp.left.val + \,\);
                }
                else{
                    sb.append(\1001,\);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    sb.append(temp.right.val + \,\);
                }
                else{
                    sb.append(\1001,\);
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        String[] values = data.split(\,\);
        int n = values.length;
        int[] nodes = new int[n];
        
        for (int i = 0; i < n; i++) {
            nodes[i] = Integer.parseInt(values[i]);
        }
        
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int index = 1;
        while (!queue.isEmpty() && index < n) {
            TreeNode currentNode = queue.poll();
            
            // Handle left child
            if (nodes[index] != 1001) {
                currentNode.left = new TreeNode(nodes[index]);
                queue.add(currentNode.left);
            }
            index++;
            
            // Handle right child
            if (index < n && nodes[index] != 1001) {
                currentNode.right = new TreeNode(nodes[index]);
                queue.add(currentNode.right);
            }
            index++;
        }
        
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));