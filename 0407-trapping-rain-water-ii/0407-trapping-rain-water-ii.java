class Solution {
    public int trapRainWater(int[][] height) {
        int m = height.length;
        int n = height[0].length;
        int totalWater = 0;
        int x[] = {0,1,0,-1};
        int y[] = {1,0,-1,0};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<n;i++){
            pq.add(new int[]{height[0][i],0,i});
            pq.add(new int[]{height[m-1][i],m-1,i});
            visited[0][i] = true;
            visited[m-1][i] = true;
        }
        for(int i=1;i<m-1;i++){
            pq.add(new int[]{height[i][0],i,0});
            pq.add(new int[]{height[i][n-1],i,n-1});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int curHeight = cur[0];
            int i = cur[1];
            int j = cur[2];
            for (int k = 0; k < 4; k++) {
                int ni = i + x[k];
                int nj = j + y[k];
                if (isValidIndex(ni, nj, m, n) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (curHeight > height[ni][nj]) {
                        totalWater += curHeight - height[ni][nj];
                        height[ni][nj] = curHeight;
                    }
                    pq.add(new int[]{height[ni][nj], ni, nj});
                }
            }
        }
        return totalWater;
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}