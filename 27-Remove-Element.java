class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int left = 0;
        int right = n - 1;
        while(left < right){
            while(left < n && nums[left] != val)
                left++;
            while(right >= 0 && nums[right] == val)
                right--;
            if(left < right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        return left;
    }
    public void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}