class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0) && wordSearch(0,i,j,board,word,m,n))
                    return true;
            }
        }
        return false;        
    }
    public boolean wordSearch(int index,int i,int j,char[][] board, String word,int m,int n){
        if(word.length() == index)
            return true;
        
        if( i < 0 || i >= m ||
            j < 0 || j >=n ||
            word.charAt(index) != board[i][j] ||
            visited[i][j]
        ){
            return false;
        }

        visited[i][j] = true;

        if(
            wordSearch(index + 1,i+1,j,board,word,m,n) ||
            wordSearch(index + 1,i-1,j,board,word,m,n) ||
            wordSearch(index + 1,i,j+1,board,word,m,n) ||
            wordSearch(index + 1,i,j-1,board,word,m,n) 
        ){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}