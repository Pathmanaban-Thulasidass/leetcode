class Solution {
    public int findPeakElement(int[] nums) {
        int i, n = nums.length;
        for(i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1])
                break;
        }
        return i;
    }
}