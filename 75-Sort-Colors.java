class Solution {
    public void sortColors(int[] nums) {
        interChange(nums,2,0);
        interChange(nums,2,1);
        interChange(nums,1,0);
    }
    public void interChange(int nums[],int leftVal,int rightVal){
        int left = 0;
        int right = nums.length - 1;
        while(left<nums.length && nums[left] != leftVal){
            left++;
        }
        while(right >= 0 && nums[right] != rightVal){
            right--;
        }
        while(left < right){
            int t = nums[left];
            nums[left++] = nums[right];
            nums[right--] = t;
            while(left < nums.length && nums[left] != leftVal){
                left++;
            }
            while(right >= 0 && nums[right] != rightVal){
                right--;
            }
        }
    }
}