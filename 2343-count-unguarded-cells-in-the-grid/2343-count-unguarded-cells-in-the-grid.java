class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int guardSize = guards.length;
        int wallSize = walls.length;
        int x[] = {-1,0,1,0};
        int y[] = {0,1,0,-1};
        int count = 0;
        int visited[][] = new int[m][n];
        // 0 => unvisited;
        // 1 => Walls;
        // 2 => Guards;
        // 3 => watching by Guard 
        for(int i=0;i<wallSize;i++){
            visited[walls[i][0]][walls[i][1]] = 1;
        }
        for(int i=0;i<guardSize;i++){
            visited[guards[i][0]][guards[i][1]] = 2;
        }
        for(int i=0;i<guardSize;i++){
            int u = guards[i][0];
            int v = guards[i][1];
            for(int j=0;j<4;j++){
                int ni = x[j] + u;
                int nj = y[j] + v;
                while(isValidIndex(ni,nj,m,n) && visited[ni][nj] != 1 && visited[ni][nj] != 2){
                    visited[ni][nj] = 3;
                    ni = x[j] + ni;
                    nj = y[j] + nj;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}