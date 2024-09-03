class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        Set set = new HashSet<>();
        int ans [] = new int[k];
        for(int i=0;i<logs.length;i++){
            if(map.get(logs[i][0]) == null){
                Set s = new HashSet();
                s.add(logs[i][1]);
                map.put(logs[i][0],s);  
            }
            else{
                set = map.get(logs[i][0]);
                set.add(logs[i][1]);
                map.put(logs[i][0],set);
            }
        }
        for(int key : map.keySet()){
            ans[map.get(key).size() - 1]++;
        }
        return ans;
    }
}