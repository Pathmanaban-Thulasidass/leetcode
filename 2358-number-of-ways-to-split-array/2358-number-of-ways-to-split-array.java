class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long total = nums[0];
        long prefix[] = new long[n];
        int count = 0;
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
            total += nums[i];
        }
        for(int i=0;i<n-1;i++){
            if(prefix[i] >= total - prefix[i])
                count++;
        }
        return count; 
    }
}