class Solution {
    Map<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if(len == 0) 
            return new ArrayList<>();
        map.put('2',\abc\);
        map.put('3',\def\);
        map.put('4',\ghi\);
        map.put('5',\jkl\);
        map.put('6',\mno\);
        map.put('7',\pqrs\);
        map.put('8',\tuv\);
        map.put('9',\wxyz\);
        List<String> ans = new ArrayList<>();
        findCombination(0,len,digits,new StringBuffer(),ans);
        return ans;
    }
    public void findCombination(int indexLevel,int len,String digits,StringBuffer inner,List<String> ans){
        if(inner.length() == len){
            ans.add(inner.toString());
            return;
        }
        String s = map.get(digits.charAt(indexLevel));
        int size = s.length();
        for(int i=0;i<size;i++){
            inner.append(s.charAt(i)); 
            findCombination(indexLevel + 1,len,digits,inner,ans);
            inner.setLength(inner.length() - 1);
        }
    }
}