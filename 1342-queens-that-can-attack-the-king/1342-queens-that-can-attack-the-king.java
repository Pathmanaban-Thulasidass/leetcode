class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int n = queens.length;
        List<List<Integer>> ans = new ArrayList<>();
        int board[][] = new int[8][8];
        for(int i=0;i<n;i++){
            board[queens[i][0]][queens[i][1]] = 1;
        }
        // only 8 possiblities
        int kingI = king[0];
        int kingJ = king[1];
        //Down
        for(int i=kingI;i<8;i++){
            if(board[i][kingJ] == 1){
                ans.add(Arrays.asList(i,kingJ));
                break;
            }
        }
        //Up
        for(int i=kingI;i>=0;i--){
            if(board[i][kingJ] == 1){
                ans.add(Arrays.asList(i,kingJ));
                break;
            }
        }
        //Left
        for(int i=kingJ;i>=0;i--){
            if(board[kingI][i] == 1){
                ans.add(Arrays.asList(kingI,i));
                break;
            }
        }
        //Right
        for(int i=kingJ;i<8;i++){
            if(board[kingI][i] == 1){
                ans.add(Arrays.asList(kingI,i));
                break;
            }
        }
        //Top-Left Diagonal 
        while(kingI >= 0 && kingJ >= 0){
            if(board[kingI][kingJ] == 1){
                ans.add(Arrays.asList(kingI,kingJ));
                break;
            }
            kingI--;
            kingJ--;
        }
        //Bottom-Left Diagonal
        kingI = king[0];
        kingJ = king[1];
        while(kingI < 8 && kingJ >= 0){
            if(board[kingI][kingJ] == 1){
                ans.add(Arrays.asList(kingI,kingJ));
                break;
            }
            kingI++;
            kingJ--;
        }
        //Top-Right Diagonal
        kingI = king[0];
        kingJ = king[1];
        while(kingI >= 0 && kingJ < 8){
            if(board[kingI][kingJ] == 1){
                ans.add(Arrays.asList(kingI,kingJ));
                break;
            }
            kingI--;
            kingJ++;
        }
        //Bottom - Right Diagonal
        kingI = king[0];
        kingJ = king[1];
        while(kingI < 8 && kingJ < 8){
            if(board[kingI][kingJ] == 1){
                ans.add(Arrays.asList(kingI,kingJ));
                break;
            }
            kingI++;
            kingJ++;
        }
        return ans;
    }
}