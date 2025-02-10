class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int dist[] = new int[n * n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int curIndex = cur[0];
            int curDis = cur[1];
            if(curIndex == n * n){
                return curDis;
            }
            int range = Math.min(curIndex + 6,n * n);
            for(int i=curIndex + 1;i <= range;i++){
                int next[] = findRowAndCol(i,n);
                int tempVal = board[next[0]][next[1]];
                if(tempVal == -1){
                    if(dist[i] > curDis + 1){
                        dist[i] = curDis + 1;
                        pq.add(new int[]{i,curDis + 1});
                    }
                }
                else{
                    if(dist[tempVal] > curDis + 1){
                        dist[tempVal] = curDis + 1;
                        pq.add(new int[]{tempVal,curDis + 1}); 
                    }
                }
            }
        }
        return -1;
    }
    public int[] findRowAndCol(int cur,int n){
        int row = n - (cur / n) - 1;
        if(cur % n == 0){
            row++;
        }
        //Column
        int col = -1;
        if(n % 2 == 0){
            if(row % 2 == 0){
                col = n - (cur % n);
            }
            else{
                col = (cur % n) - 1;
            }
        }
        else{
            if(row % 2 != 0){
                col = n - (cur % n);
            }
            else{
                col = (cur % n) - 1;
            }
        }
        if(col == -1){
            col = n - 1;
        }
        else if(col == n){
            col = 0;
        }
        return new int[]{row,col};
    }
}