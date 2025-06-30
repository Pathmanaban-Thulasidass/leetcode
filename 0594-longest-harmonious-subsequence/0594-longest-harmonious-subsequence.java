class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();        
        int ans = 0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key + 1) != null){
                ans = Math.max(ans,map.get(key) + map.get(key + 1));
            }
        }
        return ans;
    }
}