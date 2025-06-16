class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                // Normalize slope direction (to handle -1/2 and 1/-2 as same)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }
                String slope = dy + "/" + dx;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            max = Math.max(max, localMax + 1);
        }
        return max;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
