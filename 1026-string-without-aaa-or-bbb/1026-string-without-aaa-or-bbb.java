class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuffer ans = new StringBuffer();
        if(a > b){
            while(a-- > 0){
                ans.append('a');
                if(a > b){
                    ans.append('a');
                    a--;
                }
                if(b-- > 0)
                    ans.append('b');
            }
            return ans.toString();
        }
        while(b-- > 0){
            ans.append('b');
            if(a < b){
                ans.append('b');
                b--;
            }
            if(a-- > 0)
                ans.append('a');
        }
        return ans.toString();
    }
}