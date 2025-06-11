class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int diagonal1[][] = new int[m+2][n+2];
        int diagonal2[][] = new int[m+2][n+2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(set.add(grid[i][j])){
                    pq.add(grid[i][j]);
                }
                diagonal1[i+1][j+1] = grid[i][j];
                diagonal2[i+1][j+1] = grid[i][j];
            }
        }
        for(int i=0;i<=m;i++){
            int tempI = i;
            int tempJ = 0;
            int sum = 0;
            while(isValidIndex(tempI,tempJ,m+1,n+1)){
                sum += diagonal1[tempI][tempJ];
                diagonal1[tempI][tempJ] = sum;
                tempI--;
                tempJ++;
            }
        }
        for(int i=1;i<=n;i++){
            int tempI = m;
            int tempJ = i;
            int sum = 0;
            while(isValidIndex(tempI,tempJ,m+1,n+1)){
                sum += diagonal1[tempI][tempJ];
                diagonal1[tempI][tempJ] = sum;
                tempI--;
                tempJ++;
            }
        }

        for(int i=0;i<=n;i++){
            int tempI = 0;
            int tempJ = i;
            int sum = 0;
            while(isValidIndex(tempI,tempJ,m+1,n+1)){
                sum += diagonal2[tempI][tempJ];
                diagonal2[tempI][tempJ] = sum;
                tempI++;
                tempJ++;
            }
        }
        for(int i=1;i<=m;i++){
            int tempI = i;
            int tempJ = 0;
            int sum = 0;
            while(isValidIndex(tempI,tempJ,m+1,n+1)){
                sum += diagonal2[tempI][tempJ];
                diagonal2[tempI][tempJ] = sum;
                tempI++;
                tempJ++;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int len = 1;
                while(true){
                    int temp = helper(i,j,len,m,n,diagonal1,diagonal2,grid);
                    if(temp == -1)
                        break;
                    if(set.add(temp))
                        pq.add(temp);
                    len++;
                }
            }
        }
        int size = Math.min(3,pq.size());
        int ans[] = new int[size];
        for(int i=0;i<size;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
    public int helper(int ai,int aj,int len,int m,int n,int diagonal1[][],int diagonal2[][],int grid[][]){
        int bi = ai + len;
        int bj = aj - len;
        if(!isCorrectIndex(bi,bj,m+1,n+1))
            return -1;
        int ci = bi + len;
        int cj = bj + len;
        if(!isCorrectIndex(ci,cj,m+1,n+1))
            return -1;
        int di = ai + len;
        int dj = aj + len;
        if(!isCorrectIndex(di,dj,m+1,n+1))
            return -1;
        int sum = 0;
        sum += diagonal1[ai][aj] - diagonal1[bi+1][bj-1];
        sum += diagonal1[di][dj] - diagonal1[ci+1][cj-1];
        sum += diagonal2[ci][cj] - diagonal2[bi-1][bj-1];
        sum += diagonal2[di][dj] - diagonal2[ai-1][aj-1];
        sum -= grid[ai-1][aj-1];
        sum -= grid[bi-1][bj-1];
        sum -= grid[ci-1][cj-1];
        sum -= grid[di-1][dj-1];
        return sum;
    }
    public boolean isValidIndex(int i,int j,int m,int n){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
    public boolean isCorrectIndex(int i,int j,int m,int n){
        return 1 <= i && i < m && 1 <= j && j < n;
    }
}