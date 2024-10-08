class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(max < piles[i])
                max = piles[i];
        }
        binarySearch(piles,0,max,h);
        System.out.println(max);
        return 0;
    }
    int binarySearch(int[] piles,int low,int high;int h){
        int sum = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            sum = 0;
            for(int i=0;i<piles.length;i++){
                sum += (piles[i] / mid) + (piles[i] % mid == 0)
            }
        }
    }
}