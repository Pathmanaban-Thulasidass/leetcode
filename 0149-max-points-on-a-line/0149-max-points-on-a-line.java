class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int max = 0;
            int infinityCount = 0; // Line Parallel to x-axis
            int zeroCount = 0; // Line Parallel to y-axis
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2){
                    infinityCount++;
                    continue;
                }
                if(y1 == y2){
                    zeroCount++;
                    continue;
                }
                double dx = x2 - x1;
                double dy = y2 - y1;
                double slope = dy / dx;
                map.put(slope,map.getOrDefault(slope,0) + 1);
                max = Math.max(max,map.get(slope));
            }
            ans = Math.max(ans,infinityCount + 1);
            ans = Math.max(ans,zeroCount + 1);
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }
}
