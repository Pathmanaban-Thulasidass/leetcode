class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int oddCount = 0;
        int evenCount = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                evenCount++;
            }
            else{
                oddCount++;
            }
        }
        max = Math.max(evenCount,oddCount);
        boolean isOdd1 = true;
        boolean isOdd2 = false;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            if(isOdd1 && nums[i] % 2 != 0){
                count1++;
                isOdd1 = false;
            }
            if(!isOdd1 && nums[i] % 2 == 0){
                count1++;
                isOdd1 = true;
            }
            if(isOdd2 && nums[i] % 2 != 0){
                count2++;
                isOdd2 = false;
            }
            if(!isOdd2 && nums[i] % 2 == 0){
                count2++;
                isOdd2 = true;
            }
        }
        return Math.max(max,Math.max(count1,count2));
    }
}