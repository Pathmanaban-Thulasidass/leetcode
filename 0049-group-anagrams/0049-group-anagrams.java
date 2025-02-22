class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            if(map.get(sortedStr) == null){
                List<String> li = new ArrayList<>();
                li.add(strs[i]);
                map.put(sortedStr,li);
            }
            else{
                map.get(sortedStr).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}