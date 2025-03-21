class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = -1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(count == 0){
                ele = nums[i];
            }
            if(ele == nums[i]){
                count++;
            }
            else if(ele != nums[i]){
                count--;
            }
        }
        return ele;
    }
}