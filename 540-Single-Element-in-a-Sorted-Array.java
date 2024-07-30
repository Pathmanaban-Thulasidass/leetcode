class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        if(n == 1 || nums[0] != nums[1]) return nums[0];
        if(nums[high] != nums[high - 1]) return nums[n-1];
        while(low <= high){
            int mid = low +(high - low) / 2;
            if(nums[mid] != nums[mid -1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if(mid%2==0){
                if(nums[mid] == nums[mid+1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else{
                if(nums[mid] == nums[mid -1])
                    low = mid + 1;
                else
                    high = mid -1;
            }
        } 
        return -1;
    }
}