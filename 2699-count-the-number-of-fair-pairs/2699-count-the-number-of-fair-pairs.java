class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        Arrays.sort(nums);
        long total = 0;
        while(left < right){
            if((nums[left] + nums[right]) > upper){
                right--;
            }
            else{
                total += (right - left);
                left++;
            }
        }
        left = 0;
        right = n - 1;
        while(left < right){
            if((nums[left] + nums[right]) > lower - 1){
                right--;
            }
            else{
                total -= (right - left);
                left++;
            }
        }
        return total;
    }
}