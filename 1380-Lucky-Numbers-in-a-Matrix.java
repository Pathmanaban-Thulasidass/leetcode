class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minArr[] = new int[m];
        int maxArr[] = new int[n];
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int min,max;
        for(int i=0;i<m;i++){
            min = 999999;
            for(int j=0;j<n;j++){
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                }
            }
            minArr[i] = min;
        }
        for(int i=0;i<n;i++){
            max = 0;
            for(int j=0;j<m;j++){
                if(max < matrix[j][i]){
                    max = matrix[j][i];
                }
            }
            maxArr[i] = max;
        }
        for(int i=0;i<m;i++){
            set.add(minArr[i]);
        }
        for(int i=0;i<n;i++){
            if(set.contains(maxArr[i]))
                ans.add(maxArr[i]);
        }
        return ans;
    }
}