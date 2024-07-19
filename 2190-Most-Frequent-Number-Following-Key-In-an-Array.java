class Solution{
    int countWords(String [] word1,String[] word2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        for(int i=0;i<word1.length;i++){
            map1.put(word1[i],map1.getOrDefault(word1[i],0) + 1);
        }
        for(int i=0;i<word2.length;i++){
            map2.put(word2[i],map2.getOrDefault(word2[i],0) + 1);
        }
        int c = 0;
        for(String s : map1.keySet()){
            if(map2.containsKey(s) && map1.get(s) == 1 && map2.get(s) == 1)
                c++;
        }
        return c;
    }
}