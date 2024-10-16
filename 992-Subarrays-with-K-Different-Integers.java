class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
    public int helper(int [] nums, int k){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int subArray = 0;
        while(right < n){
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            while(map.size() > k){
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            if(map.size() <= k){
                subArray += (right - left + 1);
            }
            right++;
        }
        return subArray;
    }
}