class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int size = meetings.length;
        int[] rooms = new int[n];
        int ans = -1;
        int maxVal = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0;i < n;i++){
            available.add(i);
        }
        for (int i = 0; i < size; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                available.add(pq.poll()[1]);
            }
            if (!available.isEmpty()) {
                int room = available.poll();
                pq.add(new int[]{end, room});
                rooms[room]++;
            } else {
                int[] next = pq.poll();
                int newEnd = next[0] + (end - start);
                int room = next[1];
                pq.add(new int[]{newEnd, room});
                rooms[room]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (rooms[i] > maxVal) {
                maxVal = rooms[i];
                ans = i;
            }
        }
        return ans;
    }
}
