class Solution {
    public boolean isValidSudoku(char[][] board) {
        int freq[] = new int[9];
        Set<Character> set;
        
        for(int i=0;i<9;i++){
            //Check Each Row Valid
            set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !set.add(board[i][j])){
                    return false;
                }
            }
            //Check Each Column Valid
            set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i] != '.' && !set.add(board[j][i])){
                    return false;
                }
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                set = new HashSet<>();
                for(int a=i;a<i+3;a++){
                    for(int b=j;b<j+3;b++){
                        if(board[a][b] != '.' && !set.add(board[a][b])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}