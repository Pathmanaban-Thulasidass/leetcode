class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> uni = new HashMap<>();
        int rep = 0,sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(uni.get(grid[i][j]) == null){
                    uni.put(grid[i][j],1);
                }
                else{
                    rep = grid[i][j];
                }
                sum += grid[i][j];
            }
        }
        int ans[] = new int[2];
        int n = grid.length * grid.length;
        int f = (n*(n+1))/2;
        ans[0] = rep;
        if(f < sum){
            ans[1] = rep - (sum - f);
        }
        else{
            ans[1] = rep + (f - sum);
        }
        return ans;
    }
}