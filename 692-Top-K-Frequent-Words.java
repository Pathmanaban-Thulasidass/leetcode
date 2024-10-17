class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.freq != a.freq) {
                return b.freq - a.freq;  // Sort by frequency in descending order
            } else {
                return a.key.compareTo(b.key);  // Sort lexicographically if frequencies are equal
            }
        });
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0) + 1);
        }
        for(String key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        for(int i=0;i<k;i++){
            ans.add(pq.poll().key);
        }
        return ans;
    }
}
class Pair{
    String key;
    int freq;
    public Pair(String key,int freq){
        this.key = key;
        this.freq = freq;
    }
}