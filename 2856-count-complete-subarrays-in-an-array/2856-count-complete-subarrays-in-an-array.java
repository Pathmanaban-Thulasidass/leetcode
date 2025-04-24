class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int totalDistCount = 0;
        int freq[] = new int[2001];
        int left = 0;
        int right = 0;
        int count = 0;
        int innerDisCount = 0;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            if(freq[nums[i]] == 1)
                totalDistCount++;
        }
        freq = new int[2001];
        while(right < n){
            freq[nums[right]]++;
            if(freq[nums[right]] == 1)
                innerDisCount++;
            while(left <= right && innerDisCount == totalDistCount){
                count += (n - right);
                freq[nums[left]]--;
                if(freq[nums[left]] == 0)
                    innerDisCount--;
                left++;
            }
            right++;
        }
        return count;
    }
}