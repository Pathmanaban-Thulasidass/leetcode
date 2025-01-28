class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int x[] = {-1,0,1,0};
        int y[] = {0,1,0,-1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int dist[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){   
            int cur[] = pq.poll();
            int curDis = cur[0];
            int curX = cur[1];
            int curY = cur[2];
            if(curX == m - 1 && curY == n - 1){
                return curDis;
            }
            for(int i=0;i<4;i++){
                int nx = curX + x[i];
                int ny = curY + y[i];
                if(isValidIndex(nx,ny,m,n)){
                    int maxInPath = Math.max(curDis,Math.abs(heights[curX][curY] - heights[nx][ny]));
                    if(dist[nx][ny] > maxInPath){
                        dist[nx][ny] = maxInPath;
                        pq.add(new int[]{maxInPath,nx,ny});
                    }
                }
            }
        }
        return -1;        
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}