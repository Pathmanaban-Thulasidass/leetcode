class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        StringBuffer ans = new StringBuffer();
        List<StringBuffer> li = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            li.add(new StringBuffer(""));
        }
        int i = 0;
        while(i < n){
            for(int ptr = 0;ptr < numRows && i < n;ptr++){
                li.get(ptr).append(s.charAt(i));
                i++;
            }
            for(int ptr = numRows - 2;ptr >= 1 && i < n;ptr--){
                li.get(ptr).append(s.charAt(i));
                i++;
            }
        }
        for(i=0;i<numRows;i++)
            ans.append(li.get(i));
        return ans.toString();
    }
}