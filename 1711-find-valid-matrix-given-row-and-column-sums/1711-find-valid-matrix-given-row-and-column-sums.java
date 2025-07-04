class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int ans[][] = new int[m][n];
        PriorityQueue<int[]> rowPq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> colPq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0;i<m;i++){
            rowPq.add(new int[]{rowSum[i],i});
        }
        for(int i=0;i<n;i++){
            colPq.add(new int[]{colSum[i],i});
        }
        while(!colPq.isEmpty() && !rowPq.isEmpty()){
            int rowMin[] = rowPq.poll();
            int colMin[] = colPq.poll();
            int min = Math.min(rowMin[0],colMin[0]);
            ans[rowMin[1]][colMin[1]] = min;
            if(rowMin[0] - min > 0){
                rowPq.add(new int[]{rowMin[0] - min,rowMin[1]});
            }
            if(colMin[0] - min > 0){
                colPq.add(new int[]{colMin[0] - min,colMin[1]});
            }
        }
        return ans;
    }
}