class Solution {
    public long repairCars(int[] ranks, int cars) {
        return binarySearch(ranks, cars);
    }

    public long binarySearch(int[] ranks, int cars) {
        int n = ranks.length;
        long low = 1;
        long high = Long.MAX_VALUE;
        long ans = -1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long noOfCars = 0;
            for (int i = 0; i < n; i++) {
                noOfCars += (long) Math.sqrt(mid / ranks[i]);
            }
            if (noOfCars >= cars) {  
                ans = mid;
                high = mid - 1;  
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }
}
