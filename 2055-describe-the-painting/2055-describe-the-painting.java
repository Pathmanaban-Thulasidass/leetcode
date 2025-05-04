class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int n = segments.length;
        TreeMap<Integer,Long> map = new TreeMap<>();
        List<List<Long>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int start = segments[i][0];
            int end = segments[i][1];
            int color = segments[i][2];
            map.put(start,map.getOrDefault(start,0L) + color);
            map.put(end,map.getOrDefault(end,0L) - color);
        }   
        int prev = 0;
        long sum = 0;
        for(int key : map.keySet()){
            if(prev != 0 && sum != 0){
                List<Long> inner = new ArrayList<>();
                inner.add((long)prev);
                inner.add((long)key);
                inner.add(sum);
                ans.add(inner);
            }
            sum += map.get(key);
            prev = key;
        }
        return ans;        
    }
}