class Solution {
    public int minimumBeautifulSubstrings(String s) {
        List<List<String>> ans = new ArrayList<>();
        beautifulFun(0,s,ans,new ArrayList<>());
        if(ans.size() == 0)
            return -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ans.size();i++){
            if(min > ans.get(i).size()){
                min = ans.get(i).size();
            }
        }
        return min;

    }
    public void beautifulFun(int startIndex,String s,List<List<String>> ans,List<String> inner){
        if(s.length() == startIndex){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isPowerFive(s,startIndex,i+1)){
                inner.add(s.substring(startIndex,i+1));
                beautifulFun(i + 1,s,ans,inner);
                inner.remove(inner.size() - 1);
            }
        }
    }
    public boolean isPowerFive(String s,int a,int b){
        String temp = s.substring(a,b);
        if (temp.charAt(0) == '0') 
            return false;
        try {
            long val = Long.parseLong(temp,2);
            while (val > 1 && val % 5 == 0) {
                val /= 5;
            }
            return val == 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}