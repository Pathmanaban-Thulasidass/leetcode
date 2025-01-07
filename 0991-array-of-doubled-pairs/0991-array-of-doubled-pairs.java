class Solution {
    final int MAX = (int)-1e6;
    public boolean canReorderDoubled(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for(int i=0;i<n;i++){
            if(map.getOrDefault(nums[i],MAX) > 0 && map.getOrDefault(2 * nums[i],MAX) > 0){
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(2 * nums[i], map.get(2 * nums[i]) - 1);
            }
        }
        for(int i=0;i<n;i++){
            if(map.get(nums[i]) != 0)
                return false;
        }
        return true;
    }
}