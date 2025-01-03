class Solution {
    public final int MOD = (int)1e9 + 7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n1 = horizontalCuts.length;
        int n2 = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long horizontalMax = Long.MIN_VALUE;
        long verticalMax = Long.MIN_VALUE;

        horizontalMax = Math.max(horizontalMax,(horizontalCuts[0] - 0));
        for(int i=0;i<n1-1;i++){
            horizontalMax = Math.max(horizontalMax,(horizontalCuts[i+1] - horizontalCuts[i]));
        }
        horizontalMax = Math.max(horizontalMax,(h - horizontalCuts[n1 - 1]));

        verticalMax = Math.max(verticalMax,(verticalCuts[0] - 0));
        for(int i=0;i<n2-1;i++){
            verticalMax = Math.max(verticalMax,(verticalCuts[i+1] - verticalCuts[i]));
        }
        verticalMax = Math.max(verticalMax,(w - verticalCuts[n2 - 1]));

        return (int)((verticalMax * horizontalMax)  % MOD);
    }
}