class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int indegree[] = new int[n];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int curVer = queue.poll();
            for(int adjVer : adj.get(curVer)){
                indegree[adjVer]--;
                if(indegree[adjVer] == 0)
                    queue.add(adjVer);
            }
            ans.add(curVer);
        }
        Collections.sort(ans);
        return ans;
    }
}