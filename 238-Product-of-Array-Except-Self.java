class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        boolean isOneZero = true;
        int zero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zero++;
                continue;
            }
            prod *= nums[i];    
        }
        if(zero > 1)
            isOneZero = false;
        for(int i=0;i<nums.length;i++){
            if(zero > 0){
                if(nums[i] != 0)
                    nums[i] = 0;
                else{
                    if(isOneZero)
                        nums[i] = prod;
                    else
                        nums[i] = 0;
                }
            }
            else
            {
                nums[i] = prod/nums[i];
            }
        }
        return nums;
    }
}