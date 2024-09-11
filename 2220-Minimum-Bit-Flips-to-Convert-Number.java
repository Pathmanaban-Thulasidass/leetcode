class Solution {
    public int minBitFlips(int start, int goal) {
        StringBuffer startSb = new StringBuffer(Integer.toString(start,2));
        StringBuffer goalSb = new StringBuffer(Integer.toString(goal,2));
        int c = 0;
        if(startSb.length() > goalSb.length()){
            while(startSb.length() != goalSb.length()){
                goalSb.insert(0,'0');
            }
        }
        else{
            while(startSb.length() != goalSb.length()){
                startSb.insert(0,'0');
            }
        }
        int l = startSb.length();
        for(int i=0;i<l;i++){
            if(startSb.charAt(i) != goalSb.charAt(i))
                c++;
        }
        return c;
    }
}