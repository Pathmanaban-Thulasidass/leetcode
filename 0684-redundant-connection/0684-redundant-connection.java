class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisJointSet djs = new DisJointSet(n);
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!djs.union(u,v)){
                return edges[i];
            }
        }
        return new int[]{-1,-1};
    }
}
class DisJointSet{
    int size[];
    int parent[];
    public DisJointSet(int n){
        size = new int[n+1];
        parent = new int[n+1];
        Arrays.fill(size,1);
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
    }
    public int findparent(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = findparent(parent[u]);
    }
    public boolean union(int u,int v){
        int ulp_u = findparent(u);
        int ulp_v = findparent(v);
        if(ulp_u == ulp_v)
            return false;
        if(size[ulp_u] > size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
        else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        return true;
    }
    
}