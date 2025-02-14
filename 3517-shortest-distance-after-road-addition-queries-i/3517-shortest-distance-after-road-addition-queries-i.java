class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int size = queries.length;
        int ans[] = new int[size];
        List<List<Integer>> adj = new ArrayList<>();   
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            adj.get(i).add(i+1);
        }
        for(int i=0;i<size;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            adj.get(u).add(v);
            ans[i] = helperDfS(adj,n);
        }
        return ans;
    }
    public int helperDfS(List<List<Integer>> adj,int n){
        boolean visited[] = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0] = true;
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curIndex = cur[0];
            int curDis = cur[1];
            if(curIndex == n - 1){
                return curDis;
            }
            for(int child : adj.get(curIndex)){
                if(!visited[child]){
                    visited[child] = true;
                    queue.add(new int[]{child,curDis + 1});
                }
            }
        }
        return -1;
    }
}
