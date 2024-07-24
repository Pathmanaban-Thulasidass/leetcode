class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(nums,0,n-1);
            return;
        }     
        int minIndex = -1;
        for(int i=n-1;i>=index;i--){
            if(nums[i] > nums[index]){
                minIndex = i;
                break;
            }
        }
        swap(nums,index,minIndex);
        reverse(nums,index+1,n-1);
    }
    public void reverse(int nums[],int left,int right){
        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
    public void swap(int nums[],int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}