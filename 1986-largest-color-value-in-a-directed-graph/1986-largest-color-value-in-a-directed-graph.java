class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        int[][] colorCount = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int curIndex = queue.poll();
            visited++;
            int colorIndex = colors.charAt(curIndex) - 'a';
            colorCount[curIndex][colorIndex]++;
            result = Math.max(result, colorCount[curIndex][colorIndex]);
            for(int child : adj.get(curIndex)) {
                for(int c = 0; c < 26; c++) {
                    colorCount[child][c] = Math.max(colorCount[child][c], colorCount[curIndex][c]);
                }
                indegree[child]--;
                if(indegree[child] == 0){
                    queue.add(child);
                }
            }
        }
        return visited == n ? result : -1;
    }
}
