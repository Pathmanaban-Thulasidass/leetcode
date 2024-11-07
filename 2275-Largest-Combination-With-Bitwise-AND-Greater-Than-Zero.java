class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int max = 0;
        for(int i=0;i<32;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(((1 << i) & candidates[j]) != 0){
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}