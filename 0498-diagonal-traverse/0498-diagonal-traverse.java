class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int ptr = 0;
        int i = 0, j = 0;

        while (ptr < m * n) {
            // Bottom to Top
            while (i >= 0 && j < n) {
                ans[ptr++] = mat[i][j];
                i--;
                j++;
            }
            if (j >= n) { 
                i += 2; 
                j--;   
            } else {   
                i++;   
            }
            // Top to Bottom
            while (i < m && j >= 0) {
                ans[ptr++] = mat[i][j];
                i++;
                j--;
            }
            if (i >= m) { 
                j += 2; 
                i--;  
            } else {  
                j++;   
            }
        }

        return ans;
    }
}
