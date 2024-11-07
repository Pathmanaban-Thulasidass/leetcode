class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] path = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean[] safe = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isCycle(i, path, visited, safe, graph)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isCycle(int vertex, boolean[] path, boolean[] visited, boolean[] safe, int[][] graph) {
        if (visited[vertex]) return !safe[vertex]; // It mean if we are already  visited mean we know if the vertex is visited or not by safe boolean arr;
        
        visited[vertex] = true;
        path[vertex] = true;
        for (int adjVer : graph[vertex]) {
            if (!visited[adjVer] && isCycle(adjVer, path, visited, safe, graph)) {
                return true;
            } else if (path[adjVer]) {
                return true;
            }
        }
        path[vertex] = false;
        safe[vertex] = true; // Mark node as safe after checking all paths becaues there is no cycle found 
        return false;
    }
}
