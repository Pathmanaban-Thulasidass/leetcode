class DetectSquares {
    int grid[][];
    public DetectSquares() {
        grid = new int[1001][1001];
    }
    
    public void add(int[] point) {
        grid[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int count = 0;
        int x = point[0];
        int y = point[1];
        for(int i=1;i<=1000;i++){
            if(!isValidIndex(x-i,y-i) || !isValidIndex(x-i,y) || !isValidIndex(x,y-i)){
                break;
            }
            count += (grid[x-i][y-i] * grid[x-i][y] * grid[x][y-i]);            
        }
        for(int i=1;i<=1000;i++){
            if(!isValidIndex(x+i,y+i) || !isValidIndex(x+i,y) || !isValidIndex(x,y+i))
                break;
            count += (grid[x+i][y+i] * grid[x+i][y] * grid[x][y+i]);
        }
        for(int i=1;i<=1000;i++){
            if(!isValidIndex(x+i,y-i) || !isValidIndex(x+i,y) || !isValidIndex(x,y-i)){
                break;
            }
            count += (grid[x+i][y-i] * grid[x+i][y] * grid[x][y-i]);
        }
        for(int i=1;i<=1000;i++){
            if(!isValidIndex(x-i,y+i) || !isValidIndex(x,y+i) || !isValidIndex(x-i,y)){
                break;
            }
            count += (grid[x-i][y+i] * grid[x][y+i] * grid[x-i][y]);
        }
        return count;
    }
    public boolean isValidIndex(int i,int j){
        return 0 <= i && i < 1001 && 0 <= j && j < 1001;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */