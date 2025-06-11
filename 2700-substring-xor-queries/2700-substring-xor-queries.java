class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        int size = queries.length;
        int ans[][] = new int[size][2];
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                if(map.get(0) == null){
                    map.put(0, new int[]{i, i});
                }
                continue;
            }
            int inner = 0;
            for(int j=0;j<30 && i + j < n;j++){
                inner = (inner << 1) | (s.charAt(i + j) - '0');
                if(map.get(inner) == null){
                    map.put(inner, new int[]{i, i + j, j + 1});
                }else {
                    int[] arr = map.get(inner);
                    if(arr[2] > j + 1){
                        map.put(inner, new int[]{i, i + j, j + 1});
                    }
                }
            }
        }
        for(int i=0;i<size;i++){
            int val = queries[i][0] ^ queries[i][1];
            if(!map.containsKey(val)){
                ans[i][0] = -1;
                ans[i][1] = -1;
            }else{
                int[] arr = map.get(val);
                ans[i][0] = arr[0];
                ans[i][1] = arr[1];
            }
        }
        return ans;
    }
}
