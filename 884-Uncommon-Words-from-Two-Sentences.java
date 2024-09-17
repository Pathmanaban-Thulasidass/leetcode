class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        String [] arr1 = s1.split(" ");
        String [] arr2 = s2.split(" ");
        int c;
        for(int i=0;i<arr1.length;i++){
            if(map.get(arr1[i]) == null){
                map.put(arr1[i],1);
            }
            else{
                c = map.get(arr1[i]);
                map.put(arr1[i],++c);
            }
        }
        for(int i=0;i<arr2.length;i++){
            if(map.get(arr2[i]) == null){
                map.put(arr2[i],1);
            }
            else{
               c = map.get(arr2[i]);
                map.put(arr2[i],++c);
            }
        }
        int j=0,size = 0;
        for(String s:map.keySet()){
            if(map.get(s) == 1)
                size++;
        }
        String res[] = new String[size];
        for(String s:map.keySet()){
            if(map.get(s) == 1)
                res[j++] = s;
        }
        return res;
    }
}