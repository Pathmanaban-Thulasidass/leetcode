class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int zeros = 0;
        while(right < n){
            if(nums[right] == 0){
                if(zeros < k){
                    zeros++;
                }
                else{
                    while(left < n && nums[left] != 0){
                        left++;
                    }
                    left++;
                }
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}