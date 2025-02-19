class Solution {
    public int findJudge(int n, int[][] trust) {
        int size = trust.length;
        int judge = -1;
        int outdegree[] = new int[n + 1];
        int indegree[] = new int[n + 1];
        for(int i=0;i<size;i++){
            int u = trust[i][0];
            int v = trust[i][1];
            indegree[v]++;
            outdegree[u]++;
        }
        for(int i=1;i<=n;i++){
            if(outdegree[i] == 0){
                if(judge != -1)
                    return -1;
                else
                    judge = i;
            }
        }
        if(judge == -1)
            return -1;
        return indegree[judge] == n - 1 ? judge : -1;
    }
}