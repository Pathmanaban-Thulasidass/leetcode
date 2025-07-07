class Solution {
    int min = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        int size = roads.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int dist = roads[i][2];
            adj.get(u).add(new int[]{v,dist});
            adj.get(v).add(new int[]{u,dist});
        }
        boolean visited[] = new boolean[n + 1];
        helper(1,adj,visited);
        return min;
    }
    public void helper(int index,List<List<int[]>> adj,boolean visited[]){
        visited[index] = true;
        for(int child[] : adj.get(index)){
            if(!visited[child[0]]){
                helper(child[0],adj,visited);
            }
            min = Math.min(min,child[1]);
        }
    }
}