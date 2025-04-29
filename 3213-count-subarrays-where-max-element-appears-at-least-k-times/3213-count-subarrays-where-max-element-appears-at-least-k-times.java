class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int left = 0;
        int right = 0;
        int innerCount = 0;
        while(right < n){
            if(nums[right] == max){
                innerCount++;
            }
            while(left <= right && innerCount >= k){
                count += n - right;
                if(nums[left] == max){
                    innerCount--;
                }
                left++;
            }
            right++;
        }
        return count;
    }
}