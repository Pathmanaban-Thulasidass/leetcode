class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); 
        TreeSet<Integer> availableServer = new TreeSet<>();
        int max = 0;
        int servers[] = new int[k];
        for(int i = 0; i < k; i++){
            availableServer.add(i);
        }
        for(int i = 0; i < n; i++){
            int assignedServer = add(arrival[i], load[i], i, k, pq, availableServer);
            if(assignedServer != -1){
                servers[assignedServer]++;
                max = Math.max(max, servers[assignedServer]);
            }
        }
        for(int i = 0; i < k; i++){
            if(max == servers[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public int add(int start, int workTime, int index, int k, PriorityQueue<int[]> pq, TreeSet<Integer> availableServer) {
        while(!pq.isEmpty() && pq.peek()[0] <= start){
            int[] finished = pq.poll();
            availableServer.add(finished[1]);
        }
        Integer assignedServer = availableServer.ceiling(index % k);
        if (assignedServer == null) {
            assignedServer = availableServer.ceiling(0);
        }
        if (assignedServer == null) {
            return -1;
        }
        pq.add(new int[]{start + workTime, assignedServer});
        availableServer.remove(assignedServer);
        return assignedServer;
    }
}
