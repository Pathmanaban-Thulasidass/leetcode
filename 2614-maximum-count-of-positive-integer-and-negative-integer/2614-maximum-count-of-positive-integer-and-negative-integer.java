class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int negEndIndex = negBinarySearch(0,n-1,nums);
        int posStartIndex = posBinarySearch(0,n-1,nums);
        return Math.max(negEndIndex + 1,n - posStartIndex);
    }
    public int negBinarySearch(int low,int high,int[] nums){
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < 0){
                index = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        return index;
    }
    public int posBinarySearch(int low,int high,int[] nums){
        int index = nums.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] <= 0){
                low = mid + 1;
            }
            else{
                index = mid;
                high = mid - 1;
            }           
        }
        return index;
    }


}