class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n+1];
        for(int k=0;k<n;k++){
            if(!visited[k]){
                dfs(k,n,visited,adj);
                count++;
            }
        }
        return count;
    }
    public void dfs(int vertex,int n,boolean[] visited,int[][] adj){
        if(visited[vertex])
            return;
        visited[vertex] = true;
        for(int i=0;i<n;i++){
            if(adj[vertex][i] == 1 && !visited[i]){
                dfs(i,n,visited,adj);
            }
        }
    }
}