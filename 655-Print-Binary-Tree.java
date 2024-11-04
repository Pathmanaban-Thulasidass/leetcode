class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int rows = height(root);
        int cols = (1 << rows) - 1;
        List<List<String>> ans = new ArrayList<>();

        // Initialize each row with empty strings
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(cols, \\));
            ans.add(row);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, (cols - 1) / 2));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int r = pair.r;
            int c = pair.c;

            ans.get(r).set(c, Integer.toString(node.val)); // Set current node's value at correct position

            int offset = (1 << (rows - r - 2)); // Offset for next row's position

            // Process left child
            if (node.left != null) {
                queue.add(new Pair(node.left, r + 1, c - offset));
            }

            // Process right child
            if (node.right != null) {
                queue.add(new Pair(node.right, r + 1, c + offset));
            }
        }
        return ans;
    }

    // Helper function to calculate height of the tree
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

// Helper class to store TreeNode and its position
class Pair {
    TreeNode node;
    int r;
    int c;

    public Pair(TreeNode node, int r, int c) {
        this.node = node;
        this.r = r;
        this.c = c;
    }
}
