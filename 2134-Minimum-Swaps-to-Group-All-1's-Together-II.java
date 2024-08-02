class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int left = 0;
        int totalOnes = 0;
        for(int i=0;i<n;i++)
            totalOnes += nums[i];
        int windowOnes = 0;
        int maxWindowOnes = 0;
        for(int right=0;right<2*n;right++){
            if(nums[right % n] == 1)
                windowOnes++;
            if((right - left + 1) > totalOnes){
                windowOnes -= nums[left % n];
                left++;
            }
            if(maxWindowOnes < windowOnes)
                maxWindowOnes = windowOnes;
        }
        return totalOnes - maxWindowOnes;
    }
}