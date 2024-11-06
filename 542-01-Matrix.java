class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int ans[][] = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //Firstly put all zero step in queue
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int i = cur[0];
            int j = cur[1];
            int step = cur[2];
            //Top
            if(i - 1 >= 0 && mat[i-1][j] == 1 && !visited[i-1][j]){
                visited[i-1][j] = true;
                queue.add(new int[]{i-1,j,step+1});
            }
            //Bottom
            if(i + 1< row && mat[i+1][j] == 1 && !visited[i+1][j]){
                visited[i+1][j] = true;
                queue.add(new int[]{i+1,j,step+1});
            }
            //Left
            if(j - 1 >= 0 && mat[i][j-1] == 1 && !visited[i][j-1]){
                visited[i][j-1] = true;
                queue.add(new int[]{i,j-1,step+1});
            }
            //Right
            if(j + 1 < col && mat[i][j+1] == 1 && !visited[i][j+1]){
                visited[i][j+1] = true;
                queue.add(new int[]{i,j+1,step+1});
            }
            ans[i][j] = step;
        }
        return ans;
    }
}