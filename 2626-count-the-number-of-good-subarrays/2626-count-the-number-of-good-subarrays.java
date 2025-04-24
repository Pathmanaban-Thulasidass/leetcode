class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int innerPairCount = 0;
        while(right < n){
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            innerPairCount += map.get(nums[right]) - 1;
            while(left <= right && innerPairCount >= k){
                count += n - right;
                map.put(nums[left],map.get(nums[left]) - 1);
                innerPairCount -= map.get(nums[left]);
                left++;
            }
            right++;
        }
        return count;
    }
}