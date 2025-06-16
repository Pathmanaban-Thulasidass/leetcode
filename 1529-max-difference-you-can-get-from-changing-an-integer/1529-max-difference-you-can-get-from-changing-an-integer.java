class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
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
            int r = (s.charAt(ptr) - '0') % 10;
            if(r == from){
                r = 9;
            }
            a = a * 10 + r;
            ptr++;
        }
        if(s.charAt(0) != '1'){
            from = s.charAt(0) - '0';
        }
        else{
            for(int i=1;i<n;i++){
                char ch = s.charAt(i);
                if(ch != '1' && ch != '0'){
                    from = s.charAt(i) - '0';
                    to = 0;
                    break;
                }
            }
        }
        ptr = 0;
        while(ptr < n){
            int r = (s.charAt(ptr) - '0') % 10;
            if(r == from){
                r = to;
            }
            b = b * 10 + r;
            ptr++;
        }
        return a - b;
    }
    
}