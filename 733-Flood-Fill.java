class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int original = grid[sr][sc];
        if(original == color)
            return grid;
        queue.add(new int[]{sr,sc});
        grid[sr][sc] = color;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                int cur[] = queue.poll();
                int i = cur[0];
                int j = cur[1];
                //Top
                if(i - 1 >= 0 && grid[i-1][j] == original){
                    grid[i-1][j] = color;
                    queue.add(new int[]{i-1,j});
                }
                //Bottom
                if(i + 1 < row && grid[i+1][j] == original){
                    grid[i+1][j] = color;
                    queue.add(new int[]{i+1,j});
                }
                //Left
                if(j - 1 >= 0 && grid[i][j-1] == original){
                    grid[i][j-1] = color;
                    queue.add(new int[]{i,j-1});
                }
                //Right
                if(j + 1 < col && grid[i][j+1] == original){
                    grid[i][j+1] = color;
                    queue.add(new int[]{i,j+1});
                }
            }
        }   
        return grid;
    }
}