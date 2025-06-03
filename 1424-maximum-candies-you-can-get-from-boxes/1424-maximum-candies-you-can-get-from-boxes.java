class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < initialBoxes.length; i++){
            helper(initialBoxes[i], status, candies, keys, containedBoxes, visited);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] && status[i] == 1){
                ans += candies[i];
                candies[i] = 0;
            }
        }
        return ans;
    }
    public void helper(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes, boolean[] visited) {
        if(visited[box]) 
            return;
        visited[box] = true;
        for(int key : keys[box]) {
            if(key == box)
                continue;
            status[key] = 1;
        }
        for(int contained : containedBoxes[box]){
            helper(contained, status, candies, keys, containedBoxes, visited);
        }
    }
}
