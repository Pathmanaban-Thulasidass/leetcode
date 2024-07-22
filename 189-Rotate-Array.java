class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k%l;
        rotateArr(nums,0,l-1);
        rotateArr(nums,0,k-1);
        rotateArr(nums,k,l-1);        
    }
    public void rotateArr(int arr[],int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}