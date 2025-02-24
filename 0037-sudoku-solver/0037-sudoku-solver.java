class Solution {
    public void solveSudoku(char[][] board) {
        List<int[]> emptyPlaces = new ArrayList<>();
        boolean[][] rowValid = new boolean[9][10];  // rowValid[i][num] tracks if 'num' exists in row i
        boolean[][] colValid = new boolean[9][10];  // colValid[j][num] tracks if 'num' exists in column j
        boolean[][] boxValid = new boolean[9][10];  // boxValid[box][num] tracks if 'num' exists in 3x3 box

        // Precompute filled numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyPlaces.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0';
                    int box = (i / 3) * 3 + (j / 3);
                    rowValid[i][num] = true;
                    colValid[j][num] = true;
                    boxValid[box][num] = true;
                }
            }
        }

        helper(0, emptyPlaces, board, rowValid, colValid, boxValid);
    }

    private boolean helper(int index, List<int[]> emptyPlaces, char[][] board,
                           boolean[][] rowValid, boolean[][] colValid, boolean[][] boxValid) {
        if (index == emptyPlaces.size()) {
            return true;
        }

        int i = emptyPlaces.get(index)[0];
        int j = emptyPlaces.get(index)[1];
        int box = (i / 3) * 3 + (j / 3);

        for (int num = 1; num <= 9; num++) {
            if (!rowValid[i][num] && !colValid[j][num] && !boxValid[box][num]) {
                board[i][j] = (char) (num + '0');
                rowValid[i][num] = true;
                colValid[j][num] = true;
                boxValid[box][num] = true;

                if (helper(index + 1, emptyPlaces, board, rowValid, colValid, boxValid)) {
                    return true;
                }

                // Backtrack
                board[i][j] = '.';
                rowValid[i][num] = false;
                colValid[j][num] = false;
                boxValid[box][num] = false;
            }
        }

        return false;
    }
}
