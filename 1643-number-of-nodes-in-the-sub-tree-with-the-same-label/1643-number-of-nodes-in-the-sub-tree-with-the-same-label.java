class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int ans[] = new int[n];
        helperDFS(0,adj,labels,new boolean[n],ans);
        return ans;
    }
    public int[] helperDFS(int index,List<List<Integer>> adj,String label,boolean visited[],int ans[]){
        visited[index] = true;
        int count[] = new int[26];
        for(int child : adj.get(index)){
            if(!visited[child]){
                int adjFreq[] = helperDFS(child,adj,label,visited,ans);
                for(int i=0;i<26;i++){
                    count[i] += adjFreq[i];
                }
            }
        }
        count[label.charAt(index) - 'a']++;
        ans[index] = count[label.charAt(index) - 'a'];
        return count;
    }
}