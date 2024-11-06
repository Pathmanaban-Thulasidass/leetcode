class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        int indegree[] = new int[n];
        boolean path[] = new boolean[n];
        int ans[] = new int[n];
        int j = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(helperDFS(i,visited,path,adj))
                    return new int[]{};
            }
        }
        while(!queue.isEmpty()){
            int curVer = queue.poll();
            for(int adjVer : adj.get(curVer)){
                indegree[adjVer]--;
                if(indegree[adjVer] == 0)
                    queue.add(adjVer);
            }
            ans[j++] = curVer;
        }
        return j == 0 ? new int[]{} : ans;
    }
    public boolean helperDFS(int vertex,boolean visited[],boolean path[],List<List<Integer>> adj){
        visited[vertex] = true;
        path[vertex] = true;
        for(int adjVer : adj.get(vertex)){
            if(!visited[adjVer]){
                if(helperDFS(adjVer,visited,path,adj))
                    return true;
            }
            else{
                if(path[adjVer])
                    return true;
            }
        }
        path[vertex] = false;
        return false;
    }
}