class Solution {
    int ans = 0 ;
    public int findTargetSumWays(int[] nums, int target) {
        generateSeq(0,nums.length,target,0,nums);
        return ans;
    }
    public void generateSeq(int index,int n,int target,int curSum,int[] nums){
        if(index == n){
            if(curSum == target)
                ans++;
            return;
        }
        //Add
        generateSeq(index + 1,n,target,curSum + nums[index],nums);
        //Subtract
        generateSeq(index + 1,n,target,curSum - nums[index],nums);

    }
}