class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int x[] = {-1,0,1,0,-1,-1,1,1};
        int y[] = {0,1,0,-1,-1,1,1,-1};

        if(grid[0][0] == 1){
            return -1;
        }
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0]=true;
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curStep = cur[2];
           
            if(curX == n - 1 && curY == n - 1){
                return curStep;
            }
            for(int i=0;i<8;i++){
                int nx = curX + x[i];
                int ny = curY + y[i];
                if(isValidIndex(nx,ny,n) && !visited[nx][ny] && grid[nx][ny] == 0){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,curStep + 1});
                }
            }
        }
        return -1;
    }
    public boolean isValidIndex(int i,int j,int n){
        return 0 <= i && i < n && 0 <= j && j < n;
    }
    
}