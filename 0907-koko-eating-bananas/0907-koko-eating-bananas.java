class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(max < piles[i])
                max = piles[i];
        }
        return binarySearch(piles,0,max,h);
    }
    int binarySearch(int[] piles,int low,int high,int h){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;
            sum = 0;
            for(int i=0;i<piles.length;i++){
                sum += Math.ceil((double)piles[i] / mid);
            }
            if(sum > h){
                low = mid + 1;
            }
            else{
                if(min > mid)
                    min = mid;
                high = mid - 1;
            }
        }
        return min;
    }
}