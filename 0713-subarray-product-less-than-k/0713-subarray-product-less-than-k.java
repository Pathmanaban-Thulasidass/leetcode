class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) 
            return 0;
        int n = nums.length;
        int count = 0;
        int left = 0;
        int prod = 1;
        int right = 0;
        while(right < n) {
            prod *= nums[right];
            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }

        return count;
    }
}
