class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        Map<Character, Integer> sortedMap = map.entrySet()
            .stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .collect(
                Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        StringBuffer sb = new StringBuffer();
        for(char c : sortedMap.keySet()){
            int val = map.get(c);
            while(val > 0){
                sb.append(c);
                val--;
            }            
        }
        return sb.toString();
    }
}