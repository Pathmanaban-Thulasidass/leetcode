class Solution {
    public int minTime(int n, int[][] edges, int k) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        int size = edges.length;
        for(int i=0;i<size;i++){
            max = Math.max(max,edges[i][2]);
            min = Math.min(min,edges[i][2]);
        }
        int temp = binarySearch(n,min,max,edges,k);
        return temp == -1 ? 0 : temp;
    }
    public int binarySearch(int n,int low,int high,int[][] edges,int k){
        int time = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(countComponents(n,mid,edges) >= k){
                time = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return time;
    }
    public int countComponents(int n,int time,int[][] edges){
        int size = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            if(edges[i][2] > time){
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        boolean visited[] = new boolean[n];
        int components = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                helper(i,adj,visited);
                components++;
            }
        }
        return components;
    }
    public void helper(int index,List<List<Integer>> adj,boolean[] visited){
        visited[index] = true;
        for(int child : adj.get(index)){
            if(!visited[child]){
                helper(child,adj,visited);
            }
        }
    }
}