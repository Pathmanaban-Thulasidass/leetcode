class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i]);
            ans = Math.max(ans,nums[i] - min);
        }
        return ans == 0 ? -1 : ans;
    }
}