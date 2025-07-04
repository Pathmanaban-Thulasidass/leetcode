class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int ans = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][1 << n];
        int result = 0;
        for(int i=0;i<n;i++){
            int mask = 1 << i;
            queue.add(new int[]{i,0,mask}); // node steps bitmask
            result = result | mask;
            visited[i][mask] = true;
        }
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curIndex = cur[0];
            int curDist = cur[1];
            int curMask = cur[2];
            if(curMask == result){
                return curDist;
            }
            for(int child : graph[curIndex]){
                int nextMask = curMask | (1 << child);
                if(!visited[child][nextMask]){
                    visited[child][nextMask] = true;
                    queue.add(new int[]{child,curDist + 1,nextMask});
                }
            }
        }
        return -1;
    }
}