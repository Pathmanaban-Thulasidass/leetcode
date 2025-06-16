class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        int from = 9;
        int to = 1;
        for(int i=0;i<n;i++){
            if(s.charAt(i) != '9'){
                from = s.charAt(i) - '0';
                break;
            }
        }
        int a = 0;
        int b = 0;
        int ptr = 0;
        while(ptr < n){
            int r = (s.charAt(ptr) - '0');
            if(r == from){
                r = 9;
            }
            a = a * 10 + r;
            ptr++;
        }
        from = s.charAt(0) - '0';
        ptr = 0;
        while(ptr < n){
            int r = (s.charAt(ptr) - '0');
            if(r == from){
                r = 0;
            }
            b = b * 10 + r;
            ptr++;
        }
        return a - b;
    }
}