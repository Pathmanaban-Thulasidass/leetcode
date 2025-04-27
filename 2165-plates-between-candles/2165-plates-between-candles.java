class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int size = s.length();
        int leftCandle[] = new int[size];
        int rightCandle[] = new int[size];
        int plates[] = new int[size];
        int platesCount = 0;
        int ans[] = new int[n];
        int last = -1;
        for(int i=0;i<size;i++){
            if(s.charAt(i) == '|'){
                last = i;
            }
            else{
                platesCount++;
            }
            leftCandle[i] = last;
            plates[i] = platesCount;
        }
        last = size;
        for(int i=size-1;i>=0;i--){
            if(s.charAt(i) == '|'){
                last = i;
            }
            rightCandle[i] = last;
        }
        for(int i=0;i<n;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(s.charAt(start) == '*'){
                start = rightCandle[start];
            }
            if(s.charAt(end) == '*'){
                end = leftCandle[end];
            }
            if(start <= end)
                ans[i] = plates[end] - plates[start];
        }
        return ans;
    }
}