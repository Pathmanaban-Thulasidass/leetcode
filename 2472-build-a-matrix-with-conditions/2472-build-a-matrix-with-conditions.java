class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int n = rowConditions.length;
        int m = colConditions.length;
        int grid[][] = new int[k][k]; 
        HashMap<Integer,Integer> rowMap = new HashMap<>();
        HashMap<Integer,Integer> colMap = new HashMap<>();
        if(!helper(k,n,rowMap,rowConditions))
            return new int[][]{};
        if(!helper(k,m,colMap,colConditions))
            return new int[][]{};
        if(rowMap.size() != k || colMap.size() != k)
            return new int[][]{};
        for(int i=1;i<=k;i++){
            int r = rowMap.get(i);
            int c = colMap.get(i);
            grid[r][c] = i;
        }
        return grid;
    }
    public boolean helper(int k,int size,HashMap<Integer,Integer> map,int[][] condition){
        int rowOrCol = 0;
        int indegree[] = new int[k + 1];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<=k;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            int u = condition[i][0];
            int v = condition[i][1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        for(int i=1;i<=k;i++){
            if(indegree[i] == 0){
                queue.add(i);
                map.put(i,rowOrCol);
                rowOrCol++;
            }
        }
        if(queue.isEmpty())
            return false;
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            for(int child : adj.get(curNode)){
                indegree[child]--;
                if(indegree[child] == 0){
                    queue.add(child);
                    map.put(child,rowOrCol);
                    rowOrCol++;
                }
            }
        }
        return true;
    }
}