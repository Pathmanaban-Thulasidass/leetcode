class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int prefixSum = 0;
        map.put(0,1);
        int count = 0;
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            int removal = prefixSum - k;
            if(map.get(removal) != null)
                count += map.get(removal);
            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
        }
        return count;
    }
}