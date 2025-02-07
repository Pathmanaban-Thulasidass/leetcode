class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n];
        helperDFS(0,rooms,visited);
        for(int i=0;i<n;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
    public void helperDFS(int index,List<List<Integer>> rooms,boolean visited[]){
        visited[index] = true;
        for(int child : rooms.get(index)){
            if(!visited[child])
                helperDFS(child,rooms,visited);
        }
    }
}