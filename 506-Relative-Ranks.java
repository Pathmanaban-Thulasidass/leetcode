class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            pq.add(new int[]{i,score[i]});
        }
        int i = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(i == 0)
                ans[arr[0]] = \Gold Medal\;
            else if(i == 1)
                ans[arr[0]] = \Silver Medal\;
            else if(i == 2)
                ans[arr[0]] = \Bronze Medal\;
            else
                ans[arr[0]] = String.valueOf(i + 1);
            i++;
        }
        return ans;
    }
}