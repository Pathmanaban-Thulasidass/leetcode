class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        int size = connections.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            adj.get(connections[i][0]).add(new int[]{connections[i][1],1});
            adj.get(connections[i][1]).add(new int[]{connections[i][0],0});
        }
        helperDFS(0,adj,new boolean[n]);
        return count;
    }
    public void helperDFS(int index,List<List<int[]>> adj,boolean visited[]){
        visited[index] = true;
        for(int child[] : adj.get(index)){
            if(!visited[child[0]]){
                if(child[1] == 1){
                    count++;
                }
                helperDFS(child[0],adj,visited);
            }
        }
    }
}