class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        List<Integer> l = new ArrayList<>();
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
            l.add(start);
            l.add(max);
        } 
        int ans[][] = new int[l.size()/2][2];
        int j = 0;
        for(int i=0;i<l.size();i=i+2){
            ans[j][0] = l.get(i);
            ans[j++][1] = l.get(i+1); 
        }
        return ans;  
    }
}