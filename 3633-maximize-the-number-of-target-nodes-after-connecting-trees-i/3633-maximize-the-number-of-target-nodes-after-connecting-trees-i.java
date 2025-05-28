class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;
        int max = 0;
        int ans[] = new int[n+1];
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<=m;i++){
            adj2.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u = edges1[i][0];
            int v = edges1[i][1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }
        for(int i=0;i<m;i++){
            int u = edges2[i][0];
            int v = edges2[i][1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }
        for(int i=0;i<=m;i++){
            max = Math.max(max,helper(i,-1,k-1,adj2));        
        }
        for(int i=0;i<=n;i++){
            ans[i] = max + helper(i,-1,k,adj1);
        }
        return ans;
    }
    public int helper(int index,int parent,int k,List<List<Integer>> adj){
        if(k < 0)
            return 0;
        int count = 1;
        for(int child : adj.get(index)){
            if(parent != child)
                count += helper(child,index,k-1,adj);
        }
        return count;    
    }

}