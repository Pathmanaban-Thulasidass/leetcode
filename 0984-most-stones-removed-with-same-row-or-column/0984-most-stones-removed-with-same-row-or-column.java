class Solution {
    public int removeStones(int[][] stones) {
        int size = stones.length;
        int m = 0;
        int n = 0;
        int res = 0;
        for(int i=0;i<size;i++){
            m = Math.max(m,stones[i][0]);
            n = Math.max(n,stones[i][1]);
        }
        n++;
        m++;
        int rows[] = new int[m];
        int cols[] = new int[n];
        Arrays.fill(rows,-1);
        Arrays.fill(cols,-1);
        DisJointSet djs = new DisJointSet(size + 1);
        for(int i=0;i<size;i++){
            if(rows[stones[i][0]] == -1){
                rows[stones[i][0]] = i;
            }
            else{
                //rows[stones[i][0]] != -1
                int index1 = rows[stones[i][0]];
                int index2 = i;
                djs.union(index1,index2);
            }
            if(cols[stones[i][1]] == -1){
                cols[stones[i][1]] = i;
            }
            else{
                int index1 = cols[stones[i][1]];
                int index2 = i; 
                djs.union(index1,index2);
            }
        }
        for(int i=0;i<=size;i++){
            if(i == djs.parent[i]){
                res += djs.size[i] - 1;
            }
        }
        return res;
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