class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)bloomDay.length < (long)m * (long)k){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(min > bloomDay[i])
                min = bloomDay[i];
            if(max < bloomDay[i])
                max = bloomDay[i];
        }
        return binarySearch(bloomDay,min,max,m,k);
    }
    int binarySearch(int[] bloomDay,int low,int high,int m,int k){
        int count = 0;
        int totalCount = 0;
        int min = Integer.MAX_VALUE;
        int n = bloomDay.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            count = 0;
            totalCount = 0;
            for(int i=0;i<n;i++){
                if(mid >= bloomDay[i]){
                    count++;
                }
                else{
                    totalCount += (count/k);
                    count = 0;
                }
            }
            totalCount += (count/k);
            if(totalCount >= m){
                if(min > mid){
                    min = mid;
                }
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return min;
    }
}