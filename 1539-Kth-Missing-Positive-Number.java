class Solution {
    public int findKthPositive(int[] arr, int k) {
        return binarySearch(arr,k);
    }
    int binarySearch(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        int noMissEle = 0;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            noMissEle = arr[mid] - (mid + 1);
            if(noMissEle < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high + k + 1;
    }
}