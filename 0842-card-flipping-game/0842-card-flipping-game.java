class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        boolean flag[] = new boolean[2001];
        boolean present[] = new boolean[2001];
        for(int i=0;i<n;i++){
            if(fronts[i] == backs[i]){
                flag[fronts[i]] = true;
            }
            present[fronts[i]] = true;
            present[backs[i]] = true;
        }
        for(int i=1;i<=2000;i++){
            if(present[i] && !flag[i])
                return i;
        }
        return 0;
    }
}