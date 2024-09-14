class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;
        for(int i=0;i<nums.length;i++){
            if(maxValue < nums[i])
                maxValue = nums[i];
        }
        int c=1,ans = 0,j=0,i=0;
        while(j<nums.length){
            if(maxValue == nums[j]){
                c = j - i + 1;
            }
            else{
                i = j + 1;
                c = 1;
            }
            j++;
            ans = Math.max(ans,c);
        }
        return ans;
    }
}