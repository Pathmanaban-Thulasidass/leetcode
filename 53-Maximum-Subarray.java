class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tsum = nums[0];
        for(int i=1;i<nums.length;i++){
            tsum = Math.max(tsum+nums[i],nums[i]);
            max = Math.max(max,tsum);
        }
        return max;
    }
}