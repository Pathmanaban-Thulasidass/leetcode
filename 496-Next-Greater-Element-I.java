class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        int max = 0;
        int index = 0;
        int resI = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    index = j;
                    max = nums2[j];
                }
            }
            for(int k=index+1;k<nums2.length;k++){
                if(max < nums2[k]){
                    max = nums2[k];
                    break;
                }
            }
            if(max == nums2[index]){
                res[resI++] = -1;
            }
            else{
                res[resI++] = max ;
            }
        }
        return res;
    }
}