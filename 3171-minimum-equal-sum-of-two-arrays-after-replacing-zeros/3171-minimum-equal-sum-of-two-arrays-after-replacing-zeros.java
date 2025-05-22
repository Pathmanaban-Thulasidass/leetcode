class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int zeros1 = 0;
        int zeros2 = 0;
        int n = nums1.length;
        for(int i=0;i<n;i++){
            if(nums1[i] == 0){
                zeros1++;
                sum1 += 1;
            }
            else
                sum1 += nums1[i];
        }
        n = nums2.length;
        for(int i=0;i<n;i++){
            if(nums2[i] == 0){
                zeros2++;
                sum2 += 1;
            }
            else
                sum2 += nums2[i];
        }
        if(zeros1 == 0 && zeros2 == 0 && sum1 != sum2){
            return -1;
        }
        if(zeros1 == 0){
            if(sum2 > sum1)
                return -1;
        }
        else if(zeros2 == 0){
            if(sum1 > sum2)
                return -1;
        }
        return Math.max(sum1,sum2);
    }
}