class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = Integer.MIN_VALUE;
        Arrays.sort(citations);
        for(int i=0;i<n;i++){
            if(citations[i] <= n - i){
               max = Math.max(max,citations[i]);             
            }
            else {
                max = Math.max(max,n-i);
            }
        }
        return max;
    }
}