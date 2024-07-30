class Solution {
    public int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = binarySearch(nums,target,true);
        result[1] = binarySearch(nums,target,false);
        return result;
    }
    public int binarySearch(int nums[],int target,boolean isLeft){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                index = mid;
                if(isLeft){ 
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            } 
        }
        return index;
    }
}