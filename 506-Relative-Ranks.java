class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        String[] ans = new String[n];
        Map<Integer,String> map = new HashMap<>();
        for(int val : score){
            pq.add(val);
        }
        n = pq.size();
        for(int i=0;i<n;i++){
            if(i == 0)
                map.put(pq.poll(),\Gold Medal\);
            else if(i == 1)
                map.put(pq.poll(),\Silver Medal\);
            else if(i == 2)
                map.put(pq.poll(),\Bronze Medal\);
            else
                map.put(pq.poll(),String.valueOf(i + 1));
        }
        n = score.length;
        for(int i=0;i<n;i++){
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}