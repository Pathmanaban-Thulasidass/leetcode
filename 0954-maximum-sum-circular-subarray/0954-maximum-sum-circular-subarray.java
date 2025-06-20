class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i%n];
            min = Math.min(min,sum);
            if(sum > 0){
                sum = 0;
            }
        }
        if(total == min)
            return max;
        ans = Math.max(max,total - min);
        return ans;
    }
}