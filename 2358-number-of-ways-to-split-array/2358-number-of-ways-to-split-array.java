class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long total = 0;
        long cur = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        for(int i=0;i<n-1;i++){
            cur += nums[i];
            if(cur >= total - cur)
                count++;
        }
        return count; 
    }
}