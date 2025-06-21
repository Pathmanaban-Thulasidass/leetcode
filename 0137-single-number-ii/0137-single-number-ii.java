class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<32;i++){
            int ones = 0;
            for(int j=0;j<n;j++){
                if((nums[j] & (1 << i)) != 0){
                    ones++;
                }
            }
            if(ones % 3 != 0){
                ans = ans ^ (1 << i);
            }
        }
        return ans;
    }
}