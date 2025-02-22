class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int mid = n / 2;
        int beforeMedian = mid - 1;
        double ans1 = 0;
        double ans2 = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        int count = 0;
        while(ptr1 < n1 && ptr2 < n2){
            if(nums1[ptr1] < nums2[ptr2]){
                if(count == mid){
                    ans1 = nums1[ptr1];
                }
                else if(count == beforeMedian){
                    ans2 = nums1[ptr1];
                }
                ptr1++;
            }
            else if(nums1[ptr1] > nums2[ptr2]){
                if(count == mid){
                    ans1 = nums2[ptr2];
                }
                else if(count == beforeMedian){
                    ans2 = nums2[ptr2];
                }
                ptr2++;
            }
            else{
                if(count == mid){
                    ans1 = nums1[ptr1];
                }
                else if(count == beforeMedian){
                    ans2 = nums1[ptr1];
                }
                ptr1++;
            }
            count++;
        }
        while(ptr1 < n1){
            if(count == mid){
                ans1 = nums1[ptr1];
            }
            else if(count == beforeMedian){
                ans2 = nums1[ptr1];
            }
            ptr1++;
            count++;
        }
        while(ptr2 < n2){
            if(count == mid){
                ans1 = nums2[ptr2];
            }
            else if(count == beforeMedian){
                ans2 = nums2[ptr2];
            }
            ptr2++;
            count++;
        }
        if(n % 2 != 0)
            return ans1;
        return (ans1 + ans2) / 2;
    }
}