class Solution {
    public int searchInsert(int[] nums, int target) {
        int i,n = nums.length;
        if(target < nums[0])
            return 0;
        else if(target > nums[n-1])
            return n;
        else{
            int low = 0;
            int high = n-1;
            int mid = -1;
            boolean flag = false;
            while(low <= high){
                mid = (low + high) / 2;
                if(nums[mid] == target){
                    flag = true;
                    break;
                }
                else if(nums[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            if(flag){
                return mid;
            }
            return low;
        }
        
    }
}