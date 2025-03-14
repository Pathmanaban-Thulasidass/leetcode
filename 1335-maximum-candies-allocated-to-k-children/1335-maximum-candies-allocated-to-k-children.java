class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += candies[i];
            max = Math.max(max,candies[i]);
        }
        if(sum < k){
            return 0;
        }
        else if(sum == k){
            return 1;
        }
        return binarySearch(candies,max,k);
    }
    public int binarySearch(int[] candies,int max,long k){
        int n = candies.length;
        int low = 1;
        int high = max;
        int ans = 0;
        boolean flag = false;
        long possiblePiles = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            possiblePiles = 0;
            flag = false;
            for(int i=0;i<n;i++){
                possiblePiles += candies[i] / mid;
                if(possiblePiles >= k){
                    flag = true;
                    break;
                }
            }
            if(flag){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}