class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int val : nums){
            map.put(val,map.getOrDefault(val,0) + 1);
        }

        for(int val : nums){
            if(map.get(val) == 0)
                continue;
            for(int i=0;i<k;i++){
                int next = val + i;
                if(map.getOrDefault(next,-1) == -1)
                    return false;
                map.put(next,map.get(next) - 1);
            }
        }
        return true;
    }
}