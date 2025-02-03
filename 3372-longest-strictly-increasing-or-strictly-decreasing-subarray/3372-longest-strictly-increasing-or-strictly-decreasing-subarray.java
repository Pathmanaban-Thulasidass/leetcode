class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int inc = 1;
        int dec = 1;
        int max = 1;
        for(int i=0;i<n-1;i++){
            if(nums[i] < nums[i+1]){
                inc++;
                max = Math.max(max,inc);
                dec = 1;
            }
            else if(nums[i] > nums[i+1]){
                dec++;
                max = Math.max(max,dec);
                inc = 1;
            }
            else{
                inc = 1;
                dec = 1;
            }
        }
        return max;
    }
}