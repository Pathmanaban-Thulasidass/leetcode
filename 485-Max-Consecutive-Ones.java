class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                ones++;
            }
            else{
                if(max < ones)
                    max = ones;
                ones = 0;
            }
        }
        if(max < ones)
            max = ones;
        return max;
    }
}