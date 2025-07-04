class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char ans[][] = new char[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],'.');
        }
        for(int i=0;i<m;i++){
            int ptr = n - 1;
            int last = n - 1; 
            while(ptr >= 0){
                int stonesCount = 0;
                while(ptr >= 0 && boxGrid[i][ptr] != '*'){
                    if(boxGrid[i][ptr] == '#')
                        stonesCount++;
                    ptr--;
                }
                for(int j=last;j>ptr;j--){
                    if(stonesCount > 0){
                        ans[j][m-i-1] = '#';
                        stonesCount--;
                    }
                }
                if(ptr >= 0){
                    ans[ptr][m-i-1] = '*';
                }
                ptr--;
                last = ptr; 
            }


        }
        return ans;
    }
}