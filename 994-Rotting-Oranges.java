class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int min = 0; 
        int noOfFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    noOfFresh++;
                }
            }
        }
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int k=0;k<n;k++){
                int cur[] = queue.poll();
                int i = cur[0];
                int j = cur[1];
                //Top
                if(i - 1 >= 0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    queue.add(new int[]{i-1,j});
                    noOfFresh--;
                }
                //Bottom
                if(i + 1 < row && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    queue.add(new int[]{i+1,j});
                    noOfFresh--;
                }
                //Left
                if(j - 1 >= 0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    queue.add(new int[]{i,j-1});
                    noOfFresh--;
                }
                //Right
                if(j + 1 < col && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    queue.add(new int[]{i,j+1});
                    noOfFresh--;
                }
            }
            if(queue.size() > 0){
                min++;
            }
        }
        if(noOfFresh != 0)
            return -1;
        return min;
    }
}