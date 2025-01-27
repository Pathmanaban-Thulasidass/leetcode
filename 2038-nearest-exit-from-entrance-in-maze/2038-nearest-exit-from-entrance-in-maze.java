class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int x[] = {-1,0,1,0};
        int y[] = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        queue.add(new int[]{entrance[0],entrance[1],0});
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curStep = cur[2];
            if((curX == 0 || curY == 0 || curX == m - 1 || curY == n - 1) && !(curX == entrance[0] && curY == entrance[1])){
                return curStep;
            }
            for(int i=0;i<4;i++){
                int nx = curX + x[i];
                int ny = curY + y[i];
                if(isValidIndex(nx,ny,m,n) && maze[nx][ny] == '.' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,curStep + 1});
                }
            }
        }
        return -1;
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}