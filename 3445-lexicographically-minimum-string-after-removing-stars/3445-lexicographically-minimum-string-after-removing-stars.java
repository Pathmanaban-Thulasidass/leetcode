class Solution {
    public String clearStars(String s) {
        int n = s.length();
        boolean[] taken = new boolean[n + 1];
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.ch == b.ch){
                return b.index - a.index;
            }
            return a.ch - b.ch;
        });
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '*'){
                Pair cur = pq.poll();
                System.out.println(cur.index);
                taken[cur.index] = true;
                taken[i] = true;
            }
            else{
                pq.add(new Pair(s.charAt(i),i));
            }
        }
        for(int i=0;i<n;i++){
            if(!taken[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int index;
    public Pair(char ch,int index){
        this.ch = ch;
        this.index = index;
    }
}