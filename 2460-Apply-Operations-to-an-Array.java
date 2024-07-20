class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int k = 0;
        int ans[] = new int[n];
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
                i++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[k++] = nums[i];
            }
        }
        for(int i=k;i<n;i++){
            nums[i] = 0;
        }
        return nums;
    }
}