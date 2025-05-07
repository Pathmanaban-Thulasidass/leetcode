class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int x[] = {-1,0,1,0};
        int y[] = {0,1,0,-1};
        boolean visited[][] = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0,0,0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int curI = cur[0];
            int curJ = cur[1];
            int curTime = cur[2];
            if(curI == m - 1 && curJ == n - 1)
                return curTime;
            for(int i=0;i<4;i++){
                int ni = curI + x[i];
                int nj = curJ + y[i];
                if(isValidIndex(ni,nj,m,n) && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    pq.add(new int[]{ni,nj,Math.max(curTime + 1,moveTime[ni][nj] + 1)});
                }
            }
        }
        return -1;
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}