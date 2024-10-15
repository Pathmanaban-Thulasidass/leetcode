class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int n = nums.length;
       Map<Integer,Integer> map = new HashMap<>();
       map.put(0,1);
       int prefixSum = 0;
       int count = 0;
       for(int i=0;i<n;i++){
            prefixSum += nums[i];
            int removal = prefixSum - goal;
            if(map.get(removal) != null)
                count += map.get(removal);
            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
       }
       return count;
    }
}