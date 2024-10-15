class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int x:nums1){
            h1.put(x,1);
        }
        HashMap<Integer,Integer> h2 = new HashMap<>();
        for(int x:nums2){
            if(h1.containsKey(x)){
                h2.put(x,1);
            }
        }
        int[] arr = new int[h2.size()];
        int i = 0;
        for(int x:h2.keySet()){
            arr[i] = x;
            i++;
        }
        return arr;
    }
}
