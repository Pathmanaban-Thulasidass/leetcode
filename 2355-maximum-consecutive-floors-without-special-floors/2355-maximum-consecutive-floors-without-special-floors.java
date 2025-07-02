class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;
        Arrays.sort(special);
        int last = special[0];
        int ans = special[0] - bottom;
        for(int i=1;i<n;i++){
            ans = Math.max(ans,special[i] - last - 1);
            last = special[i];
        }
        ans = Math.max(ans,top - last);
        return ans;
    }
}