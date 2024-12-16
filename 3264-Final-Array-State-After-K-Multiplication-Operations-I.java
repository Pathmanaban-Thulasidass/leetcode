class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for(int i=0;i<k;i++){
            int index = findIndex(nums,n);
            nums[index] *= multiplier; 
        }
        return nums;
    }
    public int findIndex(int[] nums,int n){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<n;i++){
            if(min > nums[i]){
                min = nums[i];
                index = i;
            }
        }
        return index;
    }
}