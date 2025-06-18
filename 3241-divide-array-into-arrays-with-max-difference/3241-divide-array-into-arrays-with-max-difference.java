class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        for (int i = 0, idx = 0; i < nums.length; i+=3, idx++) {
            if (nums[i+2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[idx][0]=nums[i];
            ans[idx][1]=nums[i+1];
            ans[idx][2]=nums[i+2];
        }
        return ans;  
    }
}