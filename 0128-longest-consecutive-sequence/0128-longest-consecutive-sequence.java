class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1] - 1){
                count++;
            }
            else if(nums[i] == nums[i+1]){
                //pass
            }
            else{
                max = Math.max(max,count);
                count = 1;
            }
        }
        max = Math.max(max,count);
        return max;
    }
}