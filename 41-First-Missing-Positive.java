class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
       for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
       }
       int ptr = 1;
        for(int n : set){
            if(n > 0){
                if(ptr == n){
                    ptr++;
                }
                else{
                    return ptr;
                }
            }
        }
       return ptr;
    }
}