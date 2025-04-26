class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;
        int right = 0;
        int left = 0;
        int minCount = 0;
        int maxCount = 0;
        int nextInvalid[] = new int[n];
        int last = n;
        for(int i=n-1;i>=0;i--){
            if(nums[i] < minK || nums[i] > maxK)
                last = i;
            nextInvalid[i] = last;
        }
        while(right < n){
            if(nums[right] == minK){
                minCount++;
            }
            if(nums[right] == maxK){
                maxCount++;
            }
            if(nums[right] < minK || nums[right] > maxK){
                left = right + 1;
                minCount = 0;
                maxCount = 0;
            }
            while(left <= right && minCount > 0 && maxCount > 0){
                count += nextInvalid[right] - right;
                if(nums[left] == minK){
                    minCount--;
                }
                else if(nums[left] == maxK){
                    maxCount--;
                }
                left++;
            }
            right++;
        }
        return count;
    }
}