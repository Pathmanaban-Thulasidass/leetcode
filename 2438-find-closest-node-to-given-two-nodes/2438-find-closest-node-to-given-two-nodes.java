class Solution {
    public int closestMeetingNode(int[] arr, int node1, int node2) {
        int n = arr.length;
        int dist1[] = new int[n];
        int dist2[] = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        helper(node1,0,arr,new boolean[n],dist1);
        helper(node2,0,arr,new boolean[n],dist2);
        int meetingRoom = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE){
                continue;
            }
            max = Math.max(dist1[i],dist2[i]);
            if(min > max){
                min = max;
                meetingRoom = i;
            }
        }
        return meetingRoom;
    }
    public void helper(int index,int step,int edges[],boolean visited[],int dist1[]){
        visited[index] = true;
        dist1[index] = step;
        if(edges[index] != -1 && !visited[edges[index]]){
            helper(edges[index], step + 1,edges, visited, dist1);
        }
    }
}