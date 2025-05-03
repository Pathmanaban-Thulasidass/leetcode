class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int pos1 = tops[0]; //possible
        int pos2 = bottoms[0];
        boolean pos1Flag = true;
        boolean pos2Flag = true;
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(pos1 != tops[i] && pos1 != bottoms[i]){
                pos1Flag = false;
            }
            if(pos2 != tops[i] && pos2 != bottoms[i]){
                pos2Flag = false;
            }
            if(!pos1Flag && !pos2Flag){
                return -1;
            }
        }
        if(pos1Flag){
            ans = Math.min(ans,helper(pos1,n,tops,bottoms));
        }
        if(pos2Flag){
            ans = Math.min(ans,helper(pos2,n,tops,bottoms));
        }
        return ans;
    }
    public int helper(int searchEle,int n,int[] tops,int[] bottoms){
        int topFreq = 0;
        int bottomFreq = 0;
        int bothFreq = 0;
        for(int i=0;i<n;i++){
            if(searchEle == tops[i]){
                topFreq++;
            }
            if(searchEle == bottoms[i]){
                bottomFreq++;
            }
            if(searchEle == tops[i] && searchEle == bottoms[i]){
                bothFreq++;
            }
        }
        topFreq -= bothFreq;
        bottomFreq -= bothFreq;
        return Math.min(topFreq,bottomFreq);
    }
}