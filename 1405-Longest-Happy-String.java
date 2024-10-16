class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuffer ans = new StringBuffer();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        
        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));
        
        while (pq.size() > 1) {
            Pair temp1 = pq.poll();
            Pair temp2 = pq.poll();
            
            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != temp1.ch) {
                if(temp1.freq == 1){
                    ans.append(temp1.ch);
                    temp1.freq--;
                }
                else{
                    ans.append(temp1.ch).append(temp1.ch);
                    temp1.freq -= 2;
                }
            } else {
                ans.append(temp2.ch);
                temp2.freq--;
            }
            
            if (temp1.freq > 0) pq.add(temp1);
            if (temp2.freq > 0) pq.add(temp2);
        }

        if (!pq.isEmpty()) {
            Pair last = pq.poll();
            if(last.freq == 1){
                ans.append(last.ch);
                last.freq--;
            }
            else{
                ans.append(last.ch).append(last.ch);
                last.freq -= 2;
            }
        }
        return ans.toString();
    }
}

class Pair {
    char ch;
    int freq;
    
    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
