class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n1 = g.length;//Child
        int n2 = s.length;//Cookie
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie = 0;
        int child = 0;
        int allocated = 0;
        while(child < n1){
            while(cookie < n2 && g[child] > s[cookie]){
                cookie++;
            }
            if(cookie < n2 && g[child] <= s[cookie])
                allocated++;
            child++;
            cookie++;
        }
        return allocated;
    }
}