class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(barcodes[i],map.getOrDefault(barcodes[i],0) + 1);
        }
        for(int key : map.keySet())
            pq.add(new int[]{key,map.get(key)});
        int first[] = pq.poll();
        barcodes[0] = first[0];
        first[1]--;
        if(first[1] > 0)
            pq.add(first);
        for(int i=1;i<n;i++){
            int cur[] = pq.poll();
            if(barcodes[i-1] == cur[0]){
                int second[] = pq.poll();
                second[1]--;
                barcodes[i] = second[0];
                pq.add(second);
                pq.add(cur);
            } 
            else{
                cur[1]--;
                barcodes[i] = cur[0];
                pq.add(cur);
            }
        }
        return barcodes;

    }
}