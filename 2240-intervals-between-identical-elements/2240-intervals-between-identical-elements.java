class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long ans[] = new long[n];
        Map<Integer,Long> freq = new HashMap<>();
        Map<Integer,Long> preSum = new HashMap<>();
        for(int i=0;i<n;i++){
            ans[i] = (i * freq.getOrDefault(arr[i],0L)) - preSum.getOrDefault(arr[i],0L);
            preSum.put(arr[i],preSum.getOrDefault(arr[i],0L) + i);
            freq.put(arr[i],freq.getOrDefault(arr[i],0L) + 1);
        }
        freq = new HashMap<>();
        preSum = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            ans[i] += preSum.getOrDefault(arr[i],0L) - (i * freq.getOrDefault(arr[i],0L));
            preSum.put(arr[i],preSum.getOrDefault(arr[i],0L) + i);
            freq.put(arr[i],freq.getOrDefault(arr[i],0L) + 1);
        }
        return ans;
    }
}