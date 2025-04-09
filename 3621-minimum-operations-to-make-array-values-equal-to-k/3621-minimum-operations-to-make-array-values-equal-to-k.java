class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int freq[] = new int[101];
        int count = 0;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            if(nums[i] < k)
                return -1;
            if(freq[nums[i]] == 1 && nums[i] > k){
                count++;
            }
        }
        if(freq[k] == n)
            return 0;
        return count == 0 ? -1 : count; 
    }
}