class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,trips[i][2]);
        }
        int sweep[] = new int[max + 1];
        for(int i=0;i<n;i++){
            int passengers = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            sweep[start] += passengers;
            sweep[end] += -1 * passengers;
        }
        //PrefixSum
        int maxNeedCapacity = sweep[0];
        if(sweep[0] > capacity){
            return false;
        }
        for(int i=1;i<=max;i++){
            sweep[i] += sweep[i-1];
            if(sweep[i] > capacity){
                return false;
            }
        }
        return true;
    }
}