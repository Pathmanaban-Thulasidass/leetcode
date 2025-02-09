class Solution {
    final int x[] = {-1,0,1,0};
    final int y[] = {0,1,0,-1};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        boolean flag = false;
        for(int i=0;i<n && !flag;i++){
            for(int j=0;j<n && !flag ;j++){
                if(grid[i][j] == 1){
                    helperDFS(i,j,n,grid,visited,queue);
                    flag = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curI = cur[0];
            int curJ = cur[1];
            int curDis = cur[2];
            for(int i=0;i<4;i++){
                int ni = curI + x[i];
                int nj = curJ + y[i];
                if(isValidIndex(ni,nj,n) && !visited[ni][nj]){
                    if(grid[ni][nj] == 0){
                        queue.add(new int[]{ni,nj,curDis + 1});
                        visited[ni][nj] = true;
                    }
                    else{
                        return curDis;
                    }
                }
            }
        }
        return -1;

    }
    public void helperDFS(int i,int j,int n,int grid[][],boolean visited[][],Queue<int[]> queue){
        visited[i][j] = true;
        queue.add(new int[]{i,j,0});
        for(int k=0;k<4;k++){
            int ni = i + x[k];
            int nj = j + y[k];
            if(isValidIndex(ni,nj,n) && grid[ni][nj] == 1 && !visited[ni][nj]){
                helperDFS(ni,nj,n,grid,visited,queue);
            }
        }
    }
    public boolean isValidIndex(int i,int j,int n){
        return 0 <= i && i < n && 0 <= j && j < n;
    }
}