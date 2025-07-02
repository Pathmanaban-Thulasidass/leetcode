class Solution {
    public long minimalKSum(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int last = 0;
        long ans = 0;
        for(int i=0;i<n;i++){
            int diff = nums[i] - last;
            if(diff > 1 && k > 0){
                int min = Math.min(diff - 1,k);
                ans += findSum(last + 1,last + min);
                k -= min;
            }
            last = nums[i];
        }
        if(k > 0){
            ans += findSum(last + 1,last + k);
        }
        return ans;
    }
    public long findSum(int start, int end) {
        long sum1 = (long) end * (end + 1) / 2;
        long sum2 = (long) (start - 1) * start / 2;
        return sum1 - sum2;
    }
}