class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i] - k);
            max = Math.max(max,nums[i] + k);
        }
        int size = (max - min) + 1;
        int arr[] = new int[size + 1];
        int prefixSum[] = new int[size + 1];
        for(int i=0;i<n;i++){
            arr[nums[i] - k - min]++;
            arr[(nums[i] + k - min) + 1]--;
        }
        prefixSum[0] = arr[0];
        max = prefixSum[0];
        for(int i=1;i<size;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
            max = Math.max(max,prefixSum[i]);
        }
        return max;
    }
}