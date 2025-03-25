class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int size = rectangles.length;
        int x[][] = new int[size][2];
        int y[][] = new int[size][2];
        for(int i=0;i<size;i++){
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
             
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }
        Arrays.sort(x,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Arrays.sort(y,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int mergeCountInX = 0;
        int mergeCountInY = 0;
        int lastEnd = 0;
        for(int i=0;i<size;i++){
            if(lastEnd > x[i][0]){
                mergeCountInX++;
            }
            lastEnd = Math.max(lastEnd,x[i][1]);
        }
        lastEnd = 0;
        for(int i=0;i<size;i++){
            if(lastEnd > y[i][0]){
                mergeCountInY++;
            }
            lastEnd = Math.max(lastEnd,y[i][1]);
        }
        return (size - mergeCountInX) >= 3 || (size - mergeCountInY) >= 3;
    }
}