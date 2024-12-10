class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int n = nums.length;
        int zeros = 0;
        int [] ans = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                zeros++;
                continue;
            }
            prod *= nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                if(zeros > 1)
                    ans[i] = 0;
                else
                    ans[i] = prod;
            }
            else{
                if(zeros > 0)
                    ans[i] = 0;
                else
                    ans[i] = prod / nums[i];
            }
        }
        return ans;
    }
}