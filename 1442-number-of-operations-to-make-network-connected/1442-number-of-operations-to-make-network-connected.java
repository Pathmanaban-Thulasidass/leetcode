class Solution {
    public int makeConnected(int n, int[][] connections) {
        int size = connections.length; // total No of Edges
        if(n - 1 > size)
            return -1;
        int extras = 0;
        int noOfComponents = 0;
        DisJointSet djs = new DisJointSet(n);
        for(int i=0;i<size;i++){
            djs.union(connections[i][0],connections[i][1]);
        }
        for(int i=0;i<n;i++){
            if(djs.parent[i] == i){
                int componentSize = djs.size[i];
                int componentEdges = djs.edges[i];
                int requiredEdges = componentSize - 1;
                extras += componentEdges - requiredEdges; 
                noOfComponents++;
            }
        }
        return Math.min(extras,noOfComponents - 1);
    }
}
class DisJointSet{
    int size[];
    int parent[];
    int edges[];
    public DisJointSet(int n){
        size = new int[n];
        parent = new int[n];
        edges = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
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
        if(ulp_u == ulp_v){
            edges[ulp_u] += 1;
            return false;
        }
        if(size[ulp_u] >= size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
            edges[ulp_u] += edges[ulp_v] + 1;
        }
        else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
            edges[ulp_v] += edges[ulp_u] + 1;
        }
        return true;
    }   
}