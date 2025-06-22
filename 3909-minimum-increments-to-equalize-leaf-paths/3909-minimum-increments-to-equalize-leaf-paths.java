class Solution {
    int ans = 0;
    public int minIncrease(int n, int[][] edges, int[] cost) {
        int size = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        helper(0,new boolean[n],adj,cost);
        return ans;
    }
    public long helper(int index,boolean visited[],List<List<Integer>> adj,int cost[]){
        visited[index] = true;
        long max = 0;
        int maxCount = 0;
        int totalChilds = 0;
        for(int child : adj.get(index)){
            if(!visited[child]){
                long temp = helper(child,visited,adj,cost);
                if(max < temp){
                    max = temp;
                    maxCount = 1;
                }
                else if(max == temp){
                    maxCount++;
                }
                totalChilds++;
            }
        }
        ans += totalChilds - maxCount;
        return max + cost[index];
    }
}