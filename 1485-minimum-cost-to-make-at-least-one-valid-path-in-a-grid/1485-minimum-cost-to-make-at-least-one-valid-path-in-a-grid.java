class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int size = pq.size();
            int cur[] = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int curCost = cur[2];
            int turn = grid[x][y];
            if (visited[x][y]) continue;
            
            visited[x][y] = true;
            if (x == m - 1 && y == n - 1) {
                return curCost;
            }
            // Right
            if (isValidIndex(x, y + 1, m, n) && !visited[x][y + 1]) { // 1
                if (turn == 1) {
                    pq.add(new int[] { x, y + 1, curCost });
                } else {
                    pq.add(new int[] { x, y + 1, curCost + 1 });
                }
            }
            // Left
            if (isValidIndex(x, y - 1, m, n) && !visited[x][y - 1]) { // 2
                if (turn == 2) {
                    pq.add(new int[] { x, y - 1, curCost });
                } else {
                    pq.add(new int[] { x, y - 1, curCost + 1 });
                }
            }
            // Bottom
            if (isValidIndex(x + 1, y, m, n) && !visited[x + 1][y]) { // 3
                if (turn == 3) {
                    pq.add(new int[] { x + 1, y, curCost });
                } else {
                    pq.add(new int[] { x + 1, y, curCost + 1 });
                }
            }
            // Top
            if (isValidIndex(x - 1, y, m, n) && !visited[x - 1][y]) { // 4
                if (turn == 4) {
                    pq.add(new int[] { x - 1, y, curCost });
                } else {
                    pq.add(new int[] { x - 1, y, curCost + 1 });
                }
            }

        }
        return -1;
    }

    public boolean isValidIndex(int i, int j, int m, int n) {
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}