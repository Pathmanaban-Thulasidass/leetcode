class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        ArrayList<int[]> ans =new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
        int max = 0;
        for(int i=0;i<m;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            max = end;
            while(i<m-1 && max >= intervals[i+1][0]){
                end = intervals[i+1][1];
                if(max < end){
                    max = end;
                }
                i++;
            }
            ans.add(new int[]{start,max});
        } 
        return ans.toArray(new int[ans.size()][]);  
    }
}