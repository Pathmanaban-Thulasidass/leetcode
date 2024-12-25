class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ele = -1;
        for(int i=0;i<n;i++){
            if(count == 0){
                ele = nums[i];
                count++;
            }
            else if(ele == nums[i])
                count++;
            else
                count--;
        }
        return ele;
    }
}