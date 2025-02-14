class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int size = relations.length;
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); // index , time
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n + 1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            int u = relations[i][0];
            int v = relations[i][1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0)
                pq.add(new int[]{i,time[i-1]});
        }
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int curIndex = cur[0];
            int curTime = cur[1];
            max = Math.max(max,curTime);
            for(int child : adj.get(curIndex)){
                indegree[child]--;
                if(indegree[child] == 0){
                    pq.add(new int[]{child,curTime + time[child - 1]});
                }
            }
        }
        return max;
    }
}