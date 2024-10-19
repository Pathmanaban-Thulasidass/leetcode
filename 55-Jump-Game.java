class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxDis = 0;
        for(int i=0;i<n;i++){
            if(maxDis < (nums[i] + i)){
                if(maxDis < i)
                    return false;
                maxDis = (nums[i] + i); 
            }
        }
        return true;
    }
}