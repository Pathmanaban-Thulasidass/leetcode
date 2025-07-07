class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int size = queries.length;
        int ans[] = new int[size];
        int ptr = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        Arrays.sort(intervals,(a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int arr[][] = new int[size][2];
        for(int i=0;i<size;i++){
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        for(int i=0;i<size;i++){
            int target = arr[i][0];
            while(ptr < n && intervals[ptr][0] <= target){
                pq.add(new int[]{intervals[ptr][1] - intervals[ptr][0] + 1,intervals[ptr][1]});
                ptr++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < target){
                pq.poll();
            }
            if(pq.isEmpty()){
                ans[arr[i][1]] = -1;
            }
            else{
                ans[arr[i][1]] = pq.peek()[0];
            }
        }
        return ans;
    }
}
