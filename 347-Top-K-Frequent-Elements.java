class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for(int num : nums){
            if(map.get(num) == null){
                map.put(num,1);
                keys.add(num);
            }
            else{
                int c = map.get(num);
                map.put(num,++c);
            }
        }
        keys.sort((a,b) -> map.get(b) - map.get(a));
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = keys.get(i);
        }
        return ans;
    }
}