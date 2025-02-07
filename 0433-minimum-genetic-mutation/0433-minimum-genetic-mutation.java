class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int n = bank.length;
        int adj[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j && adj[i][j] == 0){
                    int mutation = changes(bank[i],bank[j]);
                    if(mutation == 1){
                        adj[i][j] = 1;
                        adj[j][i] = 1;
                    } 
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(changes(bank[i],startGene) == 1){
                queue.add(new int[]{i,1});
                visited[i] = true;
            }
        }
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curIndex = cur[0];
            int curStep = cur[1];
            if(bank[curIndex].equals(endGene))
                return curStep;
            for(int i=0;i<n;i++){
                if(adj[curIndex][i] == 1 && !visited[i]){
                    queue.add(new int[]{i,curStep + 1});
                    visited[i] = true;
                }
            }

        }
        return -1;
    }
    public int changes(String s1,String s2){
        int count = 0;
        for(int i=0;i<8;i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count;
    }
}