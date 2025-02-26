class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                sum--;
            }
            else{
                sum++;
            }
            if(sum == 0){
                max = Math.max(max,i + 1);
            }
            else{
                if(map.get(sum) == null){
                    map.put(sum,i);
                }
                else{
                    int firstInd = map.get(sum);
                    max = Math.max(max,i - firstInd);
                }
            }
        }
        return max;
    }
}