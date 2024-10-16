class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuffer ans = new StringBuffer();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.freq - x.freq);
        pq.add(new Pair('a',a));
        pq.add(new Pair('b',b));
        while(pq.size() != 0){
            Pair temp1 = pq.poll();
            Pair temp2 = pq.poll();
            if(ans.length() == 0 || ans.charAt(ans.length() - 1) != temp1.ch){
                if(temp1.freq == 1){
                    ans.append(temp1.ch);
                    temp1.freq--;
                }
                else{
                    ans.append(temp1.ch).append(temp1.ch);
                    temp1.freq -= 2;
                }
            }
            else{
                if(temp2 != null){
                    ans.append(temp2.ch);
                    temp2.freq--;
                }
            }
            if(temp1.freq > 0)
                pq.add(temp1);
            if(temp2 != null && temp2.freq > 0)
                pq.add(temp2);
        }

        return ans.toString();
    }
}
class Pair{
    char ch;
    int freq;
    public Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
    public String toString(){
        return ch + "  " + freq;
    }
}