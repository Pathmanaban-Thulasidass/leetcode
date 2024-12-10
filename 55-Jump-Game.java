class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxDis = 0;
        for(int i=0;i<n;i++){
            if(i > maxDis)
                return false;
            maxDis = Math.max(maxDis,i + nums[i]);
        }
        return true;
    }
}