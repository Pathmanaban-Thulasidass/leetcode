class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        long xorVal = 0;
        long sum = 0;
        int right = 0;
        int left = 0;
        int ans = 1;
        while(right < n){
            xorVal ^= nums[right];
            sum += nums[right];
            while(xorVal != sum){
                xorVal ^= nums[left];
                sum -= nums[left];
                left++;
            }
            ans = Math.max(right - left + 1,ans);
            right++;
        }
        return ans;
    }
}