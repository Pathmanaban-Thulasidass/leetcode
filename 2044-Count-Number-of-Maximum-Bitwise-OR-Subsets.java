class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for(int val : nums){
            target |= val;
        }
        return helper(0,target,0,nums.length,nums);
    }
    public int helper(int index,int target,int curOr,int n,int nums[]){
        if(index == n){
            if(curOr == target)
                return 1;
            return 0;
        }
        //Take
        int taken = helper(index + 1,target,curOr | nums[index],n,nums);
        //Don't Take
        int dontTaken = helper(index + 1,target,curOr,n,nums);
        return taken + dontTaken;
    } 
}