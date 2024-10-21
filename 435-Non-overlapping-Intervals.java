class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int i=0;i<n;i++){
            pq.add(intervals[i]);
        }
        int lastCompitionTime = pq.poll()[1];
        int nonOverLappingIntervals = 1;
        while(!pq.isEmpty()){
            int tempArr[] = pq.poll();
            if(lastCompitionTime <= tempArr[0]){
                nonOverLappingIntervals++;
                lastCompitionTime = tempArr[1];
            }
        }
        return n - nonOverLappingIntervals;
    }
}