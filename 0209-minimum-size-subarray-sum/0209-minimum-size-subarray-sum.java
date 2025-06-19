class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int preSum[] = new int[n];
        for(int i=0;i<n;i++){
            sum += nums[i];
            preSum[i] = sum;
        }
        for(int i=0;i<n;i++){
            if(preSum[i] >= target){
                int index = binarySearch(preSum,n,preSum[i] - target);
                min = Math.min(min,i - index);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public int binarySearch(int nums[],int n,int target){
        int low = 0;
        int high = n - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                index = mid;
                low = mid + 1;
            }
        }
        return index;
    }
}