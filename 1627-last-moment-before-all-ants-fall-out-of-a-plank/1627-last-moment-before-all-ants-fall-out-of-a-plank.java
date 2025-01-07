class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;
        int size = left.length;
        for(int i=0;i<size;i++){
            max = Math.max(max,left[i] - 0);
        }
        size = right.length;
        for(int i=0;i<size;i++){
            max = Math.max(max,n - right[i]);
        }
        return max;
    }
}