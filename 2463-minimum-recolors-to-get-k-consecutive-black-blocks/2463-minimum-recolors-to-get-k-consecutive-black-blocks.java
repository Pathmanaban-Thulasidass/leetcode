class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int left = 0;
        int right = k;
        int max = Integer.MIN_VALUE;
        int blackCount = 0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i) == 'B'){
                blackCount++;
            }
        }
        max = Math.max(max,blackCount);
        while(right < n){
            if(blocks.charAt(left) == 'B'){
                blackCount--;
            }
            if(blocks.charAt(right) == 'B'){
                blackCount++;
            }
            max = Math.max(max,blackCount);
            right++;
            left++;
        }
        return k - max;
    }
}