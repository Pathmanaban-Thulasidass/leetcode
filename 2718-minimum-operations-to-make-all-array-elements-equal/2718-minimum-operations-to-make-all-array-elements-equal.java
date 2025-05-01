class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        int size = queries.length;
        List<Long> ans = new ArrayList<>();
        Arrays.sort(nums);
        long preSum[] = new long[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            preSum[i] = sum;
        }
        for(int i=0;i<size;i++){
            int index = binarySearch(queries[i],n,nums);
            long pre = 0;
            long suf = 0;
            if(index == -1){
                suf = sum;
            }
            else{
                pre = preSum[index];
                suf = sum - preSum[index];
            }
            long temp = (((index + 1) * (long)queries[i]) - pre) + (suf - ((n - index - 1) * (long)queries[i]));
            ans.add(temp);
        }
        return ans;
    }
    public int binarySearch(int k,int n,int nums[]){
        int low = 0;
        int high = n - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > k){
                high = mid - 1;
            }
            else{
                index = mid;
                low = mid + 1;
            }
        }
        return index;
    }
}