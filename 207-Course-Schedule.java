class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        boolean visited[] = new boolean[n];
        boolean path[] = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(helperDFS(i,visited,path,adj))
                    return false;
            }
        }
        return true;
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