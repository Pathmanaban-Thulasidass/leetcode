class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int size = edges.length;
        int dist[] = new int[n];
        int ans = 0;
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int curindex = cur[0];
            int curDist = cur[1];
            for(int child : adj.get(curindex)){
                if(dist[child] > curDist + 1){
                    pq.add(new int[]{child,curDist + 1});
                    dist[child] = curDist + 1;
                }
            }
        }
        for(int i=1;i<n;i++){
            int totalDist = 2 * dist[i];
            if(patience[i] >= totalDist){
                ans = Math.max(totalDist,ans);
            }
            else{
                int noOfMessageCreated = (totalDist - 1) / patience[i];
                int temp = noOfMessageCreated * patience[i];
                ans = Math.max(ans,totalDist + temp);
            }
        }
        return ans + 1;
    }
}