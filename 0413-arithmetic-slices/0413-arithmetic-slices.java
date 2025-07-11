class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return 0;
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<n-1;i++){
            if(diff == Integer.MAX_VALUE){
                diff = nums[i] - nums[i+1];
                count = 2;
            }
            else{
                if(diff != nums[i] - nums[i+1]){
                    ans += helper(count);
                    diff = Integer.MAX_VALUE;
                    i--;
                }
                else{
                    count++;
                }
            }
        }
        ans += helper(count);
        return ans;
    }
    public int helper(int len){
        int temp = len - 2;
        // if(temp < 0)
        //     return 0;
        return (temp * (temp + 1)) / 2;
    }
}