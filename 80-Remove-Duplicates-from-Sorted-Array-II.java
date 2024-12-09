class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return n;
        int ptr1 = 0;
        int ptr2 = 1;
        int ptr3 = 2;
        int count = 0;
        while(ptr3 < n){
            while(nums[ptr1] == nums[ptr2] && nums[ptr2] == nums[ptr3] && nums[ptr3] != Integer.MAX_VALUE){
                moveOneStep(nums,ptr3,n);
                count++;
            }
            ptr1++;
            ptr2++;
            ptr3++;
        }
        return n - count;
    }
    public void moveOneStep(int nums[],int index,int n){
        for(int i=index;i<n-1;i++){
            nums[i] = nums[i+1];
        }
        nums[n-1] = Integer.MAX_VALUE;
    }
}