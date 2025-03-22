class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int size = edges.length;
        int count = 0;
        DisJointSet djs = new DisJointSet(n);
        for(int i=0;i<size;i++){
            djs.union(edges[i][0],edges[i][1]);
        }
        for(int i=0;i<n;i++){
            if(djs.parent[i] == i){
                int tempSize = djs.size[i];
                //n * (n - 1) = (2 * number of edges) :: n => no of vertices because it is complete graph
                // (2 * number of edges) == degree;
                if((tempSize * (tempSize - 1)) == djs.degree[i])
                    count++;
            }
        }
        return count;
    }
}
class DisJointSet{
    int size[];
    int parent[];
    int degree[];
    public DisJointSet(int n){
        size = new int[n+1];
        parent = new int[n+1];
        degree = new int[n+1];
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
        if(ulp_u == ulp_v){
            degree[ulp_u] += 2;
            return false;
        }
        if(size[ulp_u] >= size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
            degree[ulp_u] += degree[ulp_v] + 2;
        }
        else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
            degree[ulp_v] += degree[ulp_u] + 2;
        }
        return true;
    }   
}