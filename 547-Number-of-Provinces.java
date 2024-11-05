class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n+1];
        for(int k=0;k<n;k++){
            if(!visited[k]){
                queue.add(k);
                visited[k] = true;
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int i=0;i<size;i++){
                        int curVer = queue.poll();
                        for(int j=0;j<n;j++){
                            if(adj[curVer][j] == 1 && !visited[j]){
                                queue.add(j);
                                visited[j] = true;
                            }
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}