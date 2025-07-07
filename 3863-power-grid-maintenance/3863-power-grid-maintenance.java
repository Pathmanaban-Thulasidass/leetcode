class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int n = queries.length;
        int size = connections.length;
        DisJointSet djs = new DisJointSet(c);
        boolean isInActive[] = new boolean[c + 1];
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0;i<size;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            djs.union(u,v);
        }
        for(int i=1;i<=c;i++){
            if(djs.parent[i] == i){
                map.put(i,new PriorityQueue<>());
            }
        }
        for(int i=1;i<=c;i++){
            int ulp_u = djs.findparent(i);
            map.get(ulp_u).add(i);
        }
        int len = 0;
        for(int i=0;i<n;i++){
            if(queries[i][0] == 1)
                len++;
        }
        int ans[] = new int[len];
        int j = 0;
        for(int i=0;i<n;i++){
            if(queries[i][0] == 1){
                if(isInActive[queries[i][1]]){
                    int ulp_u = djs.findparent(queries[i][1]);
                    PriorityQueue<Integer> pq = map.get(ulp_u);
                    while(!pq.isEmpty() && isInActive[pq.peek()]){
                        pq.poll();
                    }
                    if(pq.isEmpty()){
                        ans[j++] = -1;
                    }
                    else{
                        ans[j++] = pq.peek();
                    }
                }
                else{
                    ans[j++] = queries[i][1];
                }
            }
            else{
                isInActive[queries[i][1]] = true;
            }
        }
        return ans;
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