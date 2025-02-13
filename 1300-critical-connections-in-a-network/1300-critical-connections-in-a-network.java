class Solution {
    int timesToReach = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj =new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();
        int size = connections.size();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }   
        for(int i=0;i<size;i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int time[] = new int[n]; //normally Reaching time
        int lowTime[] = new int[n];
        boolean visited[] = new boolean[n];
        helperDFS(0,-1,time,lowTime,adj,bridges,visited);
        return bridges;
    }
    public void helperDFS(int node,int parent,int[] time,int[] lowTime,List<List<Integer>> adj,List<List<Integer>> bridges,boolean visited[]){
        visited[node] = true;
        time[node] = lowTime[node] = timesToReach;
        timesToReach++;
        for(int child : adj.get(node)){
            if(child == parent)
                continue;
            if(!visited[child]){
                helperDFS(child,node,time,lowTime,adj,bridges,visited);
                lowTime[node] = Math.min(lowTime[node],lowTime[child]);
                if(time[node] < lowTime[child]){
                    bridges.add(Arrays.asList(child,node));
                }
            }
            else{
                lowTime[node] = Math.min(lowTime[node],lowTime[child]);
            }
        }
    }
}