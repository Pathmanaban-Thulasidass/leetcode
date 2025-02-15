class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> map = new HashMap<>();
        int eqSize = equations.size();
        int querSize = queries.size();
        double ans[] = new double[querSize];
        int index = 0; // no of nodes
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<eqSize;i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            if(map.get(u) == null){
                map.put(u,index);
                index++;
            }
            if(map.get(v) == null){
                map.put(v,index);
                index++;
            }
        }
        int noOfNodes = index;
        double adjMatrix[][] = new double[noOfNodes][noOfNodes];
        for(int i=0;i<noOfNodes;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<eqSize;i++){
            String uStr = equations.get(i).get(0);
            String vStr = equations.get(i).get(1);
            int u = map.get(uStr);
            int v = map.get(vStr);
            adj.get(u).add(v);
            adj.get(v).add(u);
            adjMatrix[u][v] = values[i];
            adjMatrix[v][u] = 1 / values[i];
        }
        for(int i=0;i<querSize;i++){
            String uStr = queries.get(i).get(0);
            String vStr = queries.get(i).get(1);
            if(map.get(uStr) == null || map.get(vStr) == null){
                ans[i] = -1;
                continue;
            }
            int u = map.get(uStr);
            int v = map.get(vStr); 
            ans[i] = helperBFS(u,v,noOfNodes,adj,adjMatrix);
        }
        return ans;
    }
    public double helperBFS(int src,int dest,int n,List<List<Integer>> adj,double adjMatrix[][]){
        if(src == dest)
            return 1;
        Queue<double[]> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        visited[src] = true;
        queue.add(new double[]{src,1.0});
        while(!queue.isEmpty()){
            double cur[] = queue.poll();
            int curNode = (int)cur[0];
            double curMul = cur[1];
            for(int child : adj.get(curNode)){
                if(!visited[child]){
                    if(child == dest){
                        return curMul * adjMatrix[curNode][child];
                    }
                    visited[child] = true;
                    queue.add(new double[]{child,curMul * adjMatrix[curNode][child]});
                }
            }
        }
        return -1;
    }
}