class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m + n; 
        int first = 0;
        int second = 0;
        while(first < m && second < n){
            if(nums1[first] > nums2[second]){
                moveOneStep(nums1,first,m);
                nums1[first] = nums2[second];
                second++;
            }
            first++;
        }
        int temp = m - 1;
        int tempSec = n - 1;
        while(tempSec >= second && second < n && temp >= 0){
            nums1[temp] = nums2[tempSec];
            temp--;
            tempSec--;
        }
    }
    public void moveOneStep(int[] nums,int index,int n){
        for(int i=n-1;i>index;i--){
           nums[i] = nums[i-1]; 
        }
    }
}