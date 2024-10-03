class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int bitIndex = 0;bitIndex < 32;bitIndex++){
            int count = 0;
            for(int i=0;i<n;i++){
                if((nums[i] & (1 << bitIndex)) != 0){
                    //Set
                    count++;
                }
            }
            if(count % 3 != 0){
                ans = ans ^ (1 << bitIndex);
            }
        }
        return ans;
    }
}