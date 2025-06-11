class Solution {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < n){
            while(right < n && nums[right] == nums[left]){
                right++;
            }
            if(right != n)
                count++;
            left++;
            right++;
        }
        return count;
    }
}