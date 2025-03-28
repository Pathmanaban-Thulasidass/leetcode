import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int row = grid.length;
        int col = grid[0].length;
        int n = queries.length;
        int[] ans = new int[n];
        int[][] arr = new int[n][2];
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        int index = 0;
        minHeap.add(new int[]{0, 0});
        visited[0][0] = true;
        while (index < n) {
            int currentQuery = arr[index][0];
            while (!minHeap.isEmpty() && grid[minHeap.peek()[0]][minHeap.peek()[1]] < currentQuery) {
                int[] cur = minHeap.poll();
                count++;
                for (int k = 0; k < 4; k++) {
                    int ni = cur[0] + x[k];
                    int nj = cur[1] + y[k];
                    if (isValidIndex(ni, nj, row, col) && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        minHeap.add(new int[]{ni, nj});
                    }
                }
            }
            while (index < n && arr[index][0] == currentQuery) {
                ans[arr[index][1]] = count;
                index++;
            }
        }

        return ans;
    }

    private boolean isValidIndex(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}