class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;   
        int ans[] = new int[n + 1];
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> freq = new HashMap<>();
        int last = -1;
        for(int i=0;i<n;i++){
            int a = adjacentPairs[i][0];
            int b = adjacentPairs[i][1];
            if(map.get(a) == null){
                map.put(a,new ArrayList<>());
            }
            map.get(a).add(b);
            if(map.get(b) == null){
                map.put(b,new ArrayList<>());
            }
            map.get(b).add(a);
            freq.put(a,freq.getOrDefault(a,0) + 1);
            freq.put(b,freq.getOrDefault(b,0) + 1);  
        }
        for(int key : freq.keySet()){
            if(freq.get(key) == 1){
                last = key;
                break;
            }
        }
        ans[0] = last;
        ans[1] = map.get(last).get(0);
        last = ans[1];
        for(int i=2;i<=n;i++){
            int temp1 = map.get(last).get(0);
            int temp2 = map.get(last).get(1);
            if(ans[i - 2] == temp1){
                ans[i] = temp2;
            }
            else{
                ans[i] = temp1;
            }
            last = ans[i];
        }
        return ans;
    }
}