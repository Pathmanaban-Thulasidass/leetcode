class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        helperDFS(0,n,graph,new ArrayList<>(),ans);
        return ans;
    }
    public void helperDFS(int index,int n,int[][] graph,List<Integer> inner,List<List<Integer>> ans){
        inner.add(index);
        if(index == n - 1){
            ans.add(new ArrayList<>(inner));
            inner.remove(inner.size() - 1);
            return;
        }
        for(int child : graph[index]){
            helperDFS(child,n,graph,inner,ans);
        }
        inner.remove(inner.size() - 1);
    }
}