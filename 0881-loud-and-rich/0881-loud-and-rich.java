class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int size = richer.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            int u = richer[i][0];
            int v = richer[i][1];
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(ans[i] == -1){
                helperDFS(i,ans,quiet,adj);
            }
        }
        return ans;
    }
    public int helperDFS(int node,int[] ans,int [] quiet,List<List<Integer>> adj){
        if(ans[node] != -1)
            return ans[node];
        int minNode = node;
        int minVal = quiet[node];
        for(int child : adj.get(node)){
            int childNode = helperDFS(child,ans,quiet,adj);
            if(minVal > quiet[childNode]){
                minVal = quiet[childNode];
                minNode = childNode;
            }
        }
        return ans[node] = minNode;
    }

}