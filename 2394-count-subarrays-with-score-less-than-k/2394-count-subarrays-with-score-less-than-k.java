class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long prefixSum[] = new long[n];
        long count = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
        for(int i=0;i<n;i++){
            count += binarySearch(i,n,k,prefixSum);
        }
        return count;
    }
    public int binarySearch(int start,int n,long k,long prefixSum[]){
        int left = start;
        int right = n - 1;
        int ptr = -1;
        long preRemovable = 0;
        if(start > 0){
            preRemovable = prefixSum[start - 1];
        }
        while(left <= right){
            int mid = (left + right) / 2;
            if(((prefixSum[mid] - preRemovable) * (mid - start + 1)) < k){
                ptr = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(ptr == -1)
            return 0;
        return ptr - start + 1;
    }
}