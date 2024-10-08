class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[] nums,int low,int high){
        if(low < high){
            int pivot = low;
            int i = low;
            int j = high;
            while(i < j){
                while(i < high && nums[i] <= nums[pivot])
                    i++;
                while(j > low && nums[j] > nums[pivot])
                    j--;
                if(i < j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            int temp = nums[pivot];
            nums[pivot] = nums[j];
            nums[j] = temp;
            quickSort(nums,low,j-1);
            quickSort(nums,j+1,high);
        }
    }
}