class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long maxDiff = 0;
        long max = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,maxDiff * nums[i]);
            max = Math.max(max,nums[i]);
            maxDiff = Math.max(maxDiff,max - nums[i]);
        }
        return ans;
    }
}