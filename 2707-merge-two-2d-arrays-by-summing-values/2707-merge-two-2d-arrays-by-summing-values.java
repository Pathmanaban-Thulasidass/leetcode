class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i][0],nums1[i][1]);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.get(nums2[i][0]) == null){
                map.put(nums2[i][0],nums2[i][1]);
            }
            else{
                int val = map.get(nums2[i][0]);
                map.put(nums2[i][0],val + nums2[i][1]);
            }
        }
        int[] ans[] = new int[map.size()][];
        int k=0;
        for(int i:map.keySet()){
            int arr [] = new int[2];
            arr[0] = i;
            arr[1] = map.get(i);
            ans[k++] = arr;
        }
        return ans;
    }
}