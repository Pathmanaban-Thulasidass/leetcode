class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int edgesSize = edges.length;
        int querySize = query.length;
        int ans[] = new int[querySize];
        DisJointSet djs = new DisJointSet(n);
        for(int i=0;i<edgesSize;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            djs.union(u,v,w);
        }
        for(int i=0;i<querySize;i++){
            int s = query[i][0];
            int t = query[i][1];
            if(djs.findparent(s) != djs.findparent(t)){
                ans[i] = -1;
            }
            else{
                int ulp = djs.findparent(s);
                ans[i] = djs.andArr[ulp];
            }
        }
        return ans;
    }
}
class DisJointSet{
    int size[];
    int parent[];
    int andArr[];
    public DisJointSet(int n){
        size = new int[n+1];
        parent = new int[n+1];
        andArr = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
            andArr[i] = -1;
        }
    }
    public int findparent(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = findparent(parent[u]);
    }
    public void union(int u,int v,int w){
        int ulp_u = findparent(u);
        int ulp_v = findparent(v);
        if(ulp_u == ulp_v){
            andArr[ulp_u] &= w;
            return;
        }
        if(size[ulp_u] >= size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
            andArr[ulp_u] = (andArr[ulp_u] == -1 ? w : andArr[ulp_u] & w);
            andArr[ulp_u] &= andArr[ulp_v];
        }
        else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
            andArr[ulp_v] = (andArr[ulp_v] == -1 ? w : andArr[ulp_v] & w);
            andArr[ulp_v] &= andArr[ulp_u];
        }
    }
    
}