class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums);
    }
    int binarySearch(int[] nums){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= nums[low]){
                if(min > nums[low]){
                    min = nums[low];
                }
                low = mid + 1;
            }
            else{
                if(min > nums[mid]){
                    min = nums[mid];
                }
                high = mid - 1;
            }
        }
        return min;
    }
}