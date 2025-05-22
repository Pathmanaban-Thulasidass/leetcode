class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int size = queries.length;
        int preSum[] = new int[n + 1];
        int sum = 0;
        for(int i=0;i<size;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            preSum[start]++;
            preSum[end + 1]--;
        }
        for(int i=0;i<n;i++){
            sum += preSum[i];
            preSum[i] = sum;
            if(preSum[i] < nums[i])
                return false;
        }
        return true;
    }
}