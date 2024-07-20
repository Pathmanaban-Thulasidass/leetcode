class Solution {
    public int findDuplicate(int[] nums) {
        boolean found[] = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(found[nums[i]] == true){
                return nums[i];
            }
            found[nums[i]] = true;
        }
        return 0;
    }
}