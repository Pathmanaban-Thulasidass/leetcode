class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int len = 1;
        for(int i=0;i<n-1;i++){
            if(colors[i] != colors[i+1]){
                len++;
            }
            else{
                if(len >= k){
                    count += len - k + 1;
                }
                len = 1;
            }
        }
        if(colors[0] != colors[n-1]){
            len++;
            for(int i=0;i<k-2;i++){
                if(colors[i] != colors[i+1]){
                    len++;
                }
                else{
                    if(len >= k){
                        count += len - k + 1;
                    }
                    len = 1;
                }
            }
        }
        if(len >= k)
            count += len - k + 1;
        return count;
    }
}