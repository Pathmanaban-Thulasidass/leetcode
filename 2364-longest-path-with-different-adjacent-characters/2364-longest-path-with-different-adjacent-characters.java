class Solution {
    int max = 0;
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        helperDFS(0,adj,s);
        return max;
    }
    public int helperDFS(int index,List<List<Integer>> adj,String s){
        int firstLargest = 0;
        int secondLargest = 0;
        for (int child : adj.get(index)) {
            int childPath = helperDFS(child, adj, s);
            if (s.charAt(index) != s.charAt(child)) {
                if (childPath > firstLargest) {
                    secondLargest = firstLargest;
                    firstLargest = childPath;
                } else if (childPath > secondLargest) {
                    secondLargest = childPath;
                }
            }
        }
        max = Math.max(max,firstLargest + secondLargest + 1);
        return firstLargest + 1; // while return i want to return the largest single path not a tree
    }
}