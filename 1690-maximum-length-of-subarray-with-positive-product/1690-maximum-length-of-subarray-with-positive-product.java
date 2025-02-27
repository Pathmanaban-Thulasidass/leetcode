class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int sign = 1;
        int count = 0;
        int revSign = 1;
        int revCount = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            count++;
            revCount++;
            if(nums[i] < 0){
                sign *= -1;
            }
            else if(nums[i] == 0){
                count = 0;
                sign = 1;
            }
            if(nums[n-i-1] < 0){
                revSign *= -1;
            }
            else if(nums[n-i-1] == 0){
                revCount = 0;
                revSign = 1;
            }

            if(sign > 0){
                max = Math.max(max,count);
            }
            if(revSign > 0){
                max = Math.max(max,revCount);
            }
        }
        return max;
    }
}