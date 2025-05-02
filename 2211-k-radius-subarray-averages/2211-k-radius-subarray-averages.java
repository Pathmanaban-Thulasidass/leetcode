class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        int left = 0;
        int right = 0;
        long innerSum = 0;
        int ptr = k;
        int noOfEle = k + k + 1;
        while(right < n && right < 2*k){
            innerSum += nums[right++];
        }
        while(right < n){
            innerSum += nums[right++];
            ans[ptr++] = (int)(innerSum / noOfEle);
            innerSum -= nums[left++];
        }
        return ans;
    }
}